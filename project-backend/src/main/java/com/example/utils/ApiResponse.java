package com.example.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public record ApiResponse<T>(int code, String message, T data) {

    // 静态方法创建一个成功的响应
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(200, "success", data);
    }

    // 静态方法创建一个自定义消息的成功响应
    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(200, message, data);
    }

    // 静态方法创建一个错误的响应
    public static <T> ApiResponse<T> error(int code, String message) {
        return new ApiResponse<>(code, message, null);
    }

    // 静态方法创建一个默认错误的响应
    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(400, message, null);
    }
}
