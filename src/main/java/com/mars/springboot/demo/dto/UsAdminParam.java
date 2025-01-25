package com.mars.springboot.demo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * Created by geyan on 2025/1/25 18:24
 */
@Setter
@Getter
public class UsAdminParam {

    @NotEmpty
    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    @NotEmpty
    @ApiModelProperty(value = "密码", required = true)
    private String password;

    @ApiModelProperty(value = "个人描述")
    private String description;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @Email
    @ApiModelProperty(value = "邮箱")
    private String email;

}

