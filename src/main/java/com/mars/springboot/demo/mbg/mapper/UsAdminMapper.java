package com.mars.springboot.demo.mbg.mapper;

import com.mars.springboot.demo.mbg.entity.UsAdmin;
import com.mars.springboot.demo.mbg.entity.UsAdminExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface UsAdminMapper {
    long countByExample(UsAdminExample example);

    int deleteByExample(UsAdminExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UsAdmin row);

    int insertSelective(UsAdmin row);

    List<UsAdmin> selectByExample(UsAdminExample example);

    UsAdmin selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") UsAdmin row, @Param("example") UsAdminExample example);

    int updateByExample(@Param("row") UsAdmin row, @Param("example") UsAdminExample example);

    int updateByPrimaryKeySelective(UsAdmin row);

    int updateByPrimaryKey(UsAdmin row);
}