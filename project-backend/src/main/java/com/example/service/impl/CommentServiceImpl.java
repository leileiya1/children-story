package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Comment;
import com.example.service.CommentService;
import com.example.mapper.CommentMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 周磊磊
* @description 针对表【comment】的数据库操作Service实现
* @createDate 2024-11-16 18:25:04
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{

    @Override
    public List<Comment> getCommentsByStoryId(Long storyId) {
        return this.list(new QueryWrapper<Comment>().eq("story_id", storyId));

    }

    @Override
    public Comment submitComment(Integer storyId, Comment comment) {
        comment.setStory_id(storyId);
        this.save(comment);
        return comment;
    }
}




