package com.example.QuestionApp.repositories;

import com.example.QuestionApp.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPostRepository extends JpaRepository<Post,Long> {
    List<Post> findByUserId(Long userid); //findBy bir kalip sonrasinda ekldeiginiz alana gore jpa bulma islemini yapar
}
