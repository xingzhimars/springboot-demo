package com.mars.springboot.demo.service.impl;

import com.mars.springboot.demo.common.utils.JwtUtil;
import com.mars.springboot.demo.dto.UsAdminLoginParam;
import com.mars.springboot.demo.dto.UsAdminParam;
import com.mars.springboot.demo.dto.UserToken;
import com.mars.springboot.demo.mbg.entity.UsAdmin;
import com.mars.springboot.demo.mbg.entity.UsAdminExample;
import com.mars.springboot.demo.mbg.mapper.UsAdminMapper;
import com.mars.springboot.demo.service.UsAdminService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by geyan on 2025/1/25 18:57
 */
@Slf4j
@Service
public class UsAdminServiceImpl implements UsAdminService {

    private final int STATUS_NORMAL = 1;
    private final int STATUS_DISABLE = 0;

    @Autowired
    private UsAdminMapper usAdminMapper;

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 1. 检查是否有相同的username；有，则注册失败；没有，则注册成功
     */
    @Override
    public UsAdmin register(UsAdminParam param) {
        UsAdmin usAdmin = new UsAdmin();
        BeanUtils.copyProperties(param, usAdmin);
        usAdmin.setCreateTime(new Date());
        usAdmin.setStatus(STATUS_NORMAL);


        UsAdminExample example = new UsAdminExample();
        example.createCriteria().andUsernameEqualTo(param.getUsername());
        val usAdmins = usAdminMapper.selectByExample(example);
        if (!usAdmins.isEmpty()) {
            return null;
        }
        int insert = usAdminMapper.insert(usAdmin);
        usAdmin.setPassword("******");

        log.info("register success, insert: {}, username: {}", insert, usAdmin.getUsername());

        return usAdmin;
    }

    /**
     * 1. 查表，是否存在username
     * 2. 检查账号状态信息，是否被禁用
     * 3. 生成token
     */
    @Override
    public String login(UsAdminLoginParam param) {
        UsAdminExample example = new UsAdminExample();
        example.createCriteria().andUsernameEqualTo(param.getUsername());
        List<UsAdmin> usAdmins = usAdminMapper.selectByExample(example);
        if (usAdmins.isEmpty()) {
            return null;
        }
        UsAdmin usAdmin = usAdmins.get(0);

        if (!usAdmin.getPassword().equals(param.getPassword())) {
            return null;
        }

        if (usAdmin.getStatus() == STATUS_DISABLE) {
            return null;
        }

        return jwtUtil.generateToken(new UserToken(usAdmin.getUsername()));
    }

    @Override
    public List<UsAdmin> listAll() {
        UsAdminExample example = new UsAdminExample();
        val usAdmins = usAdminMapper.selectByExample(example);
        if (usAdmins.isEmpty()) {
            return new ArrayList<>();
        }
        return usAdmins;
    }
}
