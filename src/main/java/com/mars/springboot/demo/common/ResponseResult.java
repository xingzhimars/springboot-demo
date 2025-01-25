package com.mars.springboot.demo.common;

import lombok.Builder;
import lombok.Data;

/**
 * Created by geyan on 2025/1/25 15:24
 */
@Data
@Builder
public class ResponseResult<T> {
    private long timestamp;
    private long eCode;
    private String eMsg;
    private T data;

    public static <T> ResponseResult<T> success() {
        return success(null);
    }

    public static <T> ResponseResult<T> success(T data) {
        return ResponseResult.<T>builder().data(data)
                .eMsg(ResponseStatus.SUCCESS.getDescription())
                .eCode(ResponseStatus.SUCCESS.getCode())
                .timestamp(System.currentTimeMillis())
                .build();
    }

    public static <T> ResponseResult<T> error() {
        return error(ResponseStatus.ERROR.getCode(), ResponseStatus.ERROR.getDescription());
    }

    public static <T> ResponseResult<T> error(long code, String message) {
        return ResponseResult.<T>builder()
                .eMsg(message)
                .eCode(code)
                .timestamp(System.currentTimeMillis())
                .build();
    }

    public static <T> ResponseResult<T> validateError(String msg) {
        return ResponseResult.<T>builder()
                .eMsg(msg)
                .eCode(ResponseStatus.VALIDATE_ERROR.getCode())
                .timestamp(System.currentTimeMillis())
                .build();
    }
}
