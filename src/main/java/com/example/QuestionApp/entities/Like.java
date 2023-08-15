package com.example.QuestionApp.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Entity
@Table(name = "p_like")
public class Like {
    @Id
    Long id;
    @ManyToOne(fetch= FetchType.LAZY) //ilgili useri bana getirmemesi icin lazy kullandik
    @JoinColumn(name="post_id",nullable = false)// userid ile user objesinin baglandigini belirtiyoruz
    @OnDelete(action= OnDeleteAction.CASCADE) // user silindiginde butun postlarini da silmek icin
    @JsonIgnore
    Post post;

    @ManyToOne(fetch= FetchType.LAZY) //ilgili useri bana getirmemesi icin lazy kullandik
    @JoinColumn(name="user_id",nullable = false)// userid ile user objesinin baglandigini belirtiyoruz
    @OnDelete(action= OnDeleteAction.CASCADE) // user silindiginde butun postlarini da silmek icin
    @JsonIgnore
    User user;
}
