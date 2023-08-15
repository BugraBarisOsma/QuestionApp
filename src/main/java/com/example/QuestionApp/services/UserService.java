package com.example.QuestionApp.services;

import com.example.QuestionApp.entities.User;
import com.example.QuestionApp.repositories.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUserId(Long userId) {
        return userRepository.findById(userId);
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long userId, User newUser) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User foundUser = user.get();
            foundUser.setUserName(newUser.getUserName());
            foundUser.setPassword(newUser.getPassword());
            userRepository.save(foundUser);
            return foundUser;
        } else {
            return null;
        }
    }

    public void deleteUserId(Long userId) {
        userRepository.deleteById(userId);

    }
}
