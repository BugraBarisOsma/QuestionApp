package com.example.QuestionApp.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "USER")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String userName;
    String password;

}
