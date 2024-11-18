package com.example.service;

import com.example.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author 周磊磊
 * @description 针对表【users】的数据库操作Service
 * @createDate 2024-11-12 15:06:52
 */
public interface UsersService extends IService<Users> {
    Users loadUser(Users user);
}
