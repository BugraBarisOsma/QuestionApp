package com.example.QuestionApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch=FetchType.LAZY) //ilgili useri bana getirmemesi icin lazy kullandik
    @JoinColumn(name="user_id",nullable = false)// userid ile user objesinin baglandigini belirtiyoruz
    @OnDelete(action= OnDeleteAction.CASCADE) // user silindiginde butun postlarini da silmek icin
    @JsonIgnore
    User user;


    String title;

    @Lob
    @Column(columnDefinition = "text")
    String text;
}
