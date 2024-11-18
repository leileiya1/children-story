package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName comment
 */
@TableName(value ="comment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    @TableField(value = "story_id")
    private Integer story_id;

    /**
     * 
     */
    @TableField(value = "user")
    private String user;

    /**
     * 
     */
    @TableField(value = "comment")
    private String comment;

    /**
     * 
     */
    @TableField(value = "rating")
    private Integer rating;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}