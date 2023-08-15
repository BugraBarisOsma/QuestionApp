package com.example.QuestionApp.controllers;

import com.example.QuestionApp.DTOs.CommentCreateDTO;
import com.example.QuestionApp.DTOs.CommentUpdateDTO;
import com.example.QuestionApp.entities.Comment;
import com.example.QuestionApp.services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {
    CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService= commentService;

    }
    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long> userId,@RequestParam Optional<Long> postId ){
        return commentService.getAllComments(userId,postId);
    }

    @GetMapping("/{commentId}")
    public Comment getComment(@PathVariable Long commentId){
        return commentService.getComment(commentId);
    }

    @PostMapping()
    public Comment createComment(@RequestBody CommentCreateDTO newComment){
        return commentService.createComment(newComment);}

    @PutMapping("/{commentId}")
    public Comment updateComment(@PathVariable Long commentId, @RequestBody CommentUpdateDTO updatedComment){
        return commentService.updateComment(commentId,updatedComment);
    }
    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long commentId){
        commentService.deleteComment(commentId);
    }
}
