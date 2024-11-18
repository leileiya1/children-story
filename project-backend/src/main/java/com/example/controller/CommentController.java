package com.example.controller;

import com.example.entity.Comment;
import com.example.service.CommentService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // 获取某个故事的评论
    @GetMapping("/{storyId}")
    public List<Comment> getComments(@PathVariable("storyId") Long storyId) {
        return commentService.getCommentsByStoryId(storyId);
    }

    // 提交评论
    @PostMapping("/{storyId}")
    public Comment submitComment(@PathVariable("storyId") Integer storyId, @RequestBody Comment comment) {
        return commentService.submitComment(storyId, comment);
    }
}

