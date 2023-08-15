package com.example.QuestionApp.controllers;

import com.example.QuestionApp.entities.User;
import com.example.QuestionApp.repositories.IUserRepository;
import com.example.QuestionApp.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/findAll")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId){
        return userService.findUserId(userId).orElse(null);
    }
    @PostMapping("/")
    public User newUser(@RequestBody User user){
        return userService.create(user);
    }
    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId,@RequestBody User newUser){
            return userService.updateUser(userId,newUser);
    }
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUserId(userId);
    }



}
