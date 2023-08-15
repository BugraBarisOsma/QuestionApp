package com.example.QuestionApp.repositories;

import com.example.QuestionApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long> {// user entity, long id
}
