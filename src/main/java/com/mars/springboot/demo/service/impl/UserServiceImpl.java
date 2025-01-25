package com.mars.springboot.demo.service.impl;

import com.mars.springboot.demo.dao.v1.UserRepository;
import com.mars.springboot.demo.entity.User;
import com.mars.springboot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by geyan on 2025/1/25 01:32
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userDao;

    @Override
    public void addUser(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> list() {
        return userDao.findAll();
    }
}
