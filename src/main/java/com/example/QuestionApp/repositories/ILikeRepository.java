package com.example.QuestionApp.repositories;

import com.example.QuestionApp.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILikeRepository extends JpaRepository<Like,Long> {
}
