package com.example.controller;

import com.alibaba.fastjson2.JSON;
import com.example.entity.Story;
import com.example.service.StoryService;
import com.example.utils.ApiResponse;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stories")
public class StoryController {

    @Autowired
    private StoryService storyService;

    // 获取故事列表
    @GetMapping
    public ApiResponse<String> getStories(@RequestParam(value = "category", defaultValue = "") String category) {
        List<Story> stories = storyService.getStoriesByCategory(category);
        return ApiResponse.success(JSON.toJSONString(stories));
    }

    // 获取某个故事的详情
    @GetMapping("/{id}")
    public ApiResponse<String> getStory(@PathVariable("id") Long id) {
        Story story = storyService.getStoryById(id);
        return ApiResponse.success(JSON.toJSONString(story));
    }
}

