package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Users;
import com.example.service.UsersService;
import com.example.mapper.UsersMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author 周磊磊
 * @description 针对表【users】的数据库操作Service实现
 * @createDate 2024-11-12 15:06:52
 */
@Service
@RequiredArgsConstructor
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users>
        implements UsersService {
    private final UsersMapper usersMapper;

    @Override
    public Users loadUser(Users user) {
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("username", user.getUsername())
                .or()
                .eq("email", user.getEmail())
                .eq("password", user.getPassword());
        return usersMapper.selectOne(wrapper);
    }
}




