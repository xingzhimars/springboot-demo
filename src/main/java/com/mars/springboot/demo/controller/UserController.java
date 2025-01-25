package com.mars.springboot.demo.controller;

import com.mars.springboot.demo.common.ResponseResult;
import com.mars.springboot.demo.dto.UsAdminParam;
import com.mars.springboot.demo.mbg.entity.UsAdmin;
import com.mars.springboot.demo.service.UserService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by geyan on 2025/1/25 01:33
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<UsAdmin> add(@RequestBody UsAdminParam param) {
        userService.addUser(param);
        return ResponseResult.success();
    }

    @RequestMapping("/list")
    @ResponseBody
    public ResponseResult<List<UsAdmin>> list() {
        val list = userService.list();
        if (list.isEmpty()) {
            return ResponseResult.error();
        }
        return ResponseResult.success(list);
    }

}
