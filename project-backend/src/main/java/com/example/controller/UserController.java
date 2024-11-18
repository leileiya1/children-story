package com.example.controller;

import com.alibaba.fastjson2.JSON;
import com.example.entity.Users;
import com.example.service.UsersService;
import com.example.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequiredArgsConstructor
public class UserController {
    private final UsersService userService;
    @PostMapping("/login")
    public ApiResponse<String> login(Users users) {
        Users user = userService.loadUser(users);
        return user!=null?ApiResponse.success(JSON.toJSONString(user)):ApiResponse.error("找不到该用户");
    }
}
