package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @TableName story
 */
@TableName(value = "story")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Story implements Serializable {
    /**
     *
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     *
     */
    @TableField(value = "title")
    private String title;

    /**
     *
     */
    @TableField(value = "description")
    private String description;

    /**
     *
     */
    @TableField(value = "image")
    private String image;

    /**
     *
     */
    @TableField(value = "category")
    private String category;

    /**
     *
     */
    @TableField(value = "content")
    private String content;
    @TableField(exist = false)
    private List<Comment> comments;
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}