package com.mars.springboot.demo.service;

import com.mars.springboot.demo.entity.User;

import java.util.List;

/**
 * Created by geyan on 2025/1/25 01:31
 */
public interface UserService {

    void addUser(User user);

    List<User> list();
}
