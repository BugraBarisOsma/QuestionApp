package com.example.QuestionApp.controllers;

import com.example.QuestionApp.DTOs.PostDTO;
import com.example.QuestionApp.DTOs.PostUpdateDTO;
import com.example.QuestionApp.entities.Post;
import com.example.QuestionApp.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
    private PostService postService;
    public PostController(PostService postService){
        this.postService=postService;
    }

    @GetMapping()
    public List<Post> getAllPosts(@RequestParam Optional<Long> userId){ // optional olmasi gelebilir gelmeyedebilir
        return postService.getAllPosts(userId);

    }
    @GetMapping("/{postId}")
    public Post getOnePost(@PathVariable Long postId){
        return postService.getOnePost(postId).orElse(null);
    }

    @PostMapping()
    public Post createPost(@RequestBody PostDTO newPost){
        return postService.createPost(newPost);

    }
    @PutMapping("/{postId}")
    public Post updatePost(@PathVariable Long postId,@RequestBody PostUpdateDTO updatePost){
        return postService.updatePost(postId,updatePost);
    }
    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Long postId){
        postService.deletePost(postId);
    }

}
