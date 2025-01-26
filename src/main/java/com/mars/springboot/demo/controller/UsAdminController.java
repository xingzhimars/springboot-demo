package com.mars.springboot.demo.controller;

import com.mars.springboot.demo.common.ResponseResult;
import com.mars.springboot.demo.dto.UsAdminLoginParam;
import com.mars.springboot.demo.dto.UsAdminParam;
import com.mars.springboot.demo.mbg.entity.UsAdmin;
import com.mars.springboot.demo.service.RedisService;
import com.mars.springboot.demo.service.UsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by geyan on 2025/1/18 00:57
 */
@Controller
@RequestMapping("/admin")
@Api(tags = "UsAdminController")
@Tag(name = "UsAdminController", description = "用户管理")
public class UsAdminController {

    @Value("${jwt.tokenPrefix}")
    private String tokenPrefix;

    @Autowired
    private UsAdminService usAdminService;

//    @Autowired
//    private RedisService<String> redisService;

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<UsAdmin> register(@Validated @RequestBody UsAdminParam param) {
        UsAdmin usAdmin = usAdminService.register(param);
        if (usAdmin == null) {
            return ResponseResult.error();
        }
        return ResponseResult.success(usAdmin);
    }


    @ApiOperation(value = "用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<Map<String, String>> login(@Validated @RequestBody UsAdminLoginParam param) {
        String token = usAdminService.login(param);
        if (token == null) {
            return ResponseResult.validateError("username or password error");
        }

//        String key = "token::" + param.getUsername();
//        redisService.set(key, token);

        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        map.put("tokenPrefix", tokenPrefix);
        return ResponseResult.success(map);
    }


    @ApiOperation(value = "列举所有用户")
    @RequestMapping(value = "/list_all", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<List<UsAdmin>> listAll() {
        val usAdmins = usAdminService.listAll();
        if (usAdmins.isEmpty()) {
            return ResponseResult.error();
        }
        return ResponseResult.success(usAdmins);
    }

}
