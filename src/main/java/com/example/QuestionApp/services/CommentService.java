package com.example.QuestionApp.services;

import com.example.QuestionApp.DTOs.CommentCreateDTO;
import com.example.QuestionApp.DTOs.CommentUpdateDTO;
import com.example.QuestionApp.entities.Comment;
import com.example.QuestionApp.entities.Post;
import com.example.QuestionApp.entities.User;
import com.example.QuestionApp.repositories.ICommentRepository;

import java.util.List;
import java.util.Optional;

public class CommentService {
    private ICommentRepository commentRepository;
    private UserService userService;
    private PostService postService;

    public CommentService(ICommentRepository commentRepository,UserService userService,PostService postService) {
        this.commentRepository = commentRepository;
        this.userService=userService;
        this.postService=postService;
    }

    public List<Comment> getAllComments(Optional<Long> userId, Optional<Long> postId) {
        if (userId.isPresent() && postId.isPresent()) {
            return commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
        } else if (userId.isPresent()) {
            return commentRepository.findByUserId(userId.get());
        } else if (postId.isPresent()) {
            return commentRepository.findByPostId(postId.get());
        } else {
            return commentRepository.findAll();
        }

    }

    public Comment getComment(Long commentId) {

        return commentRepository.findById(commentId).orElse(null);
    }

    public Comment createComment(CommentCreateDTO newComment) {//var olan bir posta ve userin postuna comment atilmasi icin once varolduklarini test ediyoruz
        Optional<User> user = userService.findUserId(newComment.getUserId());
        Optional<Post> post = postService.getOnePost(newComment.getPostId());

        if(user != null && post!= null){
            Comment commentToSave = new Comment();
            commentToSave.setId(newComment.getId());
            commentToSave.setPost(post.get());
            commentToSave.setUser(user.get());
            commentToSave.setText(newComment.getText());
            return commentRepository.save(commentToSave);
        }
        return null;

    }

    public Comment updateComment(Long commentId, CommentUpdateDTO updatedComment) {
        Optional<Comment> comment =commentRepository.findById(commentId);
        if (comment.isPresent()){
            Comment commentToUpdate=comment.get();
            commentToUpdate.setText(updatedComment.getText());
            return commentRepository.save(commentToUpdate);
        }
        return null;
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
