package com.mars.springboot.demo.service.impl;

import com.mars.springboot.demo.dto.UsAdminParam;
import com.mars.springboot.demo.mbg.entity.UsAdmin;
import com.mars.springboot.demo.mbg.entity.UsAdminExample;
import com.mars.springboot.demo.mbg.mapper.UsAdminMapper;
import com.mars.springboot.demo.service.UserService;
import lombok.val;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by geyan on 2025/1/25 01:32
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsAdminMapper usAdminMapper;

    @Override
    public void addUser(UsAdminParam param) {
        UsAdmin usAdmin = new UsAdmin();
        BeanUtils.copyProperties(param, usAdmin);
        usAdmin.setCreateTime(new Date());
        usAdminMapper.insert(usAdmin);
    }

    @Override
    public List<UsAdmin> list() {
        UsAdminExample example = new UsAdminExample();
        val usAdmins = usAdminMapper.selectByExample(example);
        if (usAdmins.isEmpty()) {
            return new ArrayList<>();
        }
        return usAdmins;
    }
}
