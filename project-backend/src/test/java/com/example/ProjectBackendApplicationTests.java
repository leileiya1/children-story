package com.example;

import com.alibaba.fastjson2.JSON;
import com.example.entity.Story;
import com.example.entity.Users;
import com.example.mapper.UsersMapper;
import com.example.service.StoryService;
import com.example.service.UsersService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProjectBackendApplicationTests {
    @Resource
    private UsersService usersService;
    @Resource
    private StoryService storyService;

    @Test
    void contextLoads() {
        List<Story> 全部 = storyService.getStoriesByCategory("科幻");
        System.out.println(JSON.toJSONString(全部));
    }

}
