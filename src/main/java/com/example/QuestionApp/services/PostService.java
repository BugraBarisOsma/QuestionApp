package com.example.QuestionApp.services;

import com.example.QuestionApp.DTOs.PostDTO;
import com.example.QuestionApp.DTOs.PostUpdateDTO;
import com.example.QuestionApp.entities.Post;
import com.example.QuestionApp.entities.User;
import com.example.QuestionApp.repositories.IPostRepository;
import com.example.QuestionApp.repositories.IUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private IPostRepository postRepository;
    private UserService userService;

    public PostService(IPostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public List<Post> getAllPosts(Optional<Long> userId) {
        if (userId.isPresent()) {
            return postRepository.findByUserId(userId.get());
        }
        return postRepository.findAll();
    }

    public Optional<Post> getOnePost(Long postId) {
        return postRepository.findById(postId);
    }

    public Post createPost(PostDTO newPost) {
        Optional<User> user = userService.findUserId(newPost.getUserId());
        if (user == null) {
            return null;
        }
        Post tempPost = new Post();
        tempPost.setId(newPost.getId());
        tempPost.setText(newPost.getText());
        tempPost.setTitle(newPost.getTitle());
        tempPost.setUser(user.get());
        return postRepository.save(tempPost);
    }

    public Post updatePost(Long postId, PostUpdateDTO updatePost) {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent()) {
            Post toUpdate = post.get();
            toUpdate.setText(updatePost.getText());
            toUpdate.setTitle(updatePost.getTitle());
            postRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
