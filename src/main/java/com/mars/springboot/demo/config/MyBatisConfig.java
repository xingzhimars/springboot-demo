package com.mars.springboot.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by geyan on 2025/1/25 18:17
 */
@Configuration
@MapperScan({"com.mars.springboot.demo.mbg.mapper","com.mars.springboot.demo.dao"})
public class MyBatisConfig {
}
