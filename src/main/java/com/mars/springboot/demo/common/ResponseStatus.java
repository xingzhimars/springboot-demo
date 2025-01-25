package com.mars.springboot.demo.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 状态码
 * Created by geyan on 2025/1/25 15:20
 */
@Getter
@AllArgsConstructor
public enum ResponseStatus {
    SUCCESS(0, "success"),
    ERROR(-1, "error");

    private final long code;
    private final String description;
}
