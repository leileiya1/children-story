package com.example.service;

import com.example.entity.Story;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 周磊磊
* @description 针对表【story】的数据库操作Service
* @createDate 2024-11-16 18:25:12
*/
public interface StoryService extends IService<Story> {

    List<Story> getStoriesByCategory(String category);

    Story getStoryById(Long id);
}
