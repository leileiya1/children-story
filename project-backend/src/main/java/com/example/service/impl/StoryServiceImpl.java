package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Comment;
import com.example.entity.Story;
import com.example.mapper.CommentMapper;
import com.example.service.StoryService;
import com.example.mapper.StoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 周磊磊
 * @description 针对表【story】的数据库操作Service实现
 * @createDate 2024-11-16 18:25:12
 */
@Service
@RequiredArgsConstructor
public class StoryServiceImpl extends ServiceImpl<StoryMapper, Story>
        implements StoryService {
    private final StoryMapper storyMapper;
    private final CommentMapper commentMapper;

    @Override
    public List<Story> getStoriesByCategory(String category) {
        QueryWrapper<Story> queryWrapper = new QueryWrapper<>();
        if (category == null || category.isEmpty() || "all".equals(category)) {
            // 不设置 category 筛选条件，返回所有故事
            return this.list();
        } else {
            queryWrapper.eq("category", category);  // 按照 category 筛选
        }
        // 查询所有故事
        List<Story> stories = storyMapper.selectList(queryWrapper);

        // 通过每个故事的 id 获取评论
        for (Story story : stories) {
            QueryWrapper<Comment> commentWrapper = new QueryWrapper<>();
            commentWrapper.eq("story_id", story.getId());
            List<Comment> comments = commentMapper.selectList(commentWrapper);  // 查询评论
            story.setComments(comments);  // 将评论设置到 Story 对象
        }

        return stories;
    }

    @Override
    public Story getStoryById(Long id) {
        QueryWrapper<Story> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return this.getOne(wrapper);
    }
}




