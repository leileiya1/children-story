package com.example.service;

import com.example.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 周磊磊
* @description 针对表【comment】的数据库操作Service
* @createDate 2024-11-16 18:25:04
*/
public interface CommentService extends IService<Comment> {

    List<Comment> getCommentsByStoryId(Long storyId);

    Comment submitComment(Integer storyId, Comment comment);
}
