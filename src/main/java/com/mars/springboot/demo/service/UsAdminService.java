package com.mars.springboot.demo.service;

import com.mars.springboot.demo.dto.UsAdminLoginParam;
import com.mars.springboot.demo.dto.UsAdminParam;
import com.mars.springboot.demo.mbg.entity.UsAdmin;

import java.util.List;

/**
 * Created by geyan on 2025/1/25 18:55
 */

public interface UsAdminService {
    UsAdmin register(UsAdminParam param);
    String login(UsAdminLoginParam param);
    List<UsAdmin> listAll();
}
