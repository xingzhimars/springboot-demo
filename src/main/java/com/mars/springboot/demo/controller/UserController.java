package com.mars.springboot.demo.controller;

import com.mars.springboot.demo.entity.User;
import com.mars.springboot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by geyan on 2025/1/25 01:33
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("add")
    public User add(User user) {
        userService.addUser(user);
        return user;
    }

    @RequestMapping("list")
    public List<User> list() {
        return userService.list();
    }

}
