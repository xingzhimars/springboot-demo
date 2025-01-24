package com.mars.springboot.demo.dao;

import com.mars.springboot.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by geyan on 2025/1/25 01:29
 */
@Repository
public class UserRepository {

    private List<User> users = new ArrayList<>();

    public void save(User user) {
        users.add(user);
    }

    public List<User> findAll() {
        return users;
    }

}
