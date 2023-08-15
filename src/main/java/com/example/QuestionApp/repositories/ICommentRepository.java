package com.example.QuestionApp.repositories;

import com.example.QuestionApp.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICommentRepository extends JpaRepository<Comment,Long> {
    
    List<Comment> findByUserIdAndPostId(Long aLong, Long aLong1);

    List<Comment> findByUserId(Long aLong);

    List<Comment> findByPostId(Long aLong);
}
