package com.mars.springboot.demo.service;

import com.mars.springboot.demo.dto.UsAdminParam;
import com.mars.springboot.demo.mbg.entity.UsAdmin;

import java.util.List;

/**
 * Created by geyan on 2025/1/25 01:31
 */
public interface UserService {

    void addUser(UsAdminParam param);

    List<UsAdmin> list();
}
