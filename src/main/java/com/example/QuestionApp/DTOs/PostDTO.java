package com.example.QuestionApp.DTOs;

import lombok.Data;

@Data
public class PostDTO {
    Long id;
    String title;
    String text;
    Long userId;
}
