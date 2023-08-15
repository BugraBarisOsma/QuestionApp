package com.example.QuestionApp.DTOs;

import lombok.Data;

@Data
public class CommentCreateDTO {
    Long id;
    Long userId;
    Long postId;
    String text;
}
