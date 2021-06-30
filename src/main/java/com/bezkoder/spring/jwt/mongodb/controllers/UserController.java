package com.bezkoder.spring.jwt.mongodb.controllers;

import com.bezkoder.spring.jwt.mongodb.models.User;
import com.bezkoder.spring.jwt.mongodb.payload.response.MessageResponse;
import com.bezkoder.spring.jwt.mongodb.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/all")
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable String userId) {
        if (userRepository.existsById(userId)){
            return ResponseEntity.ok().body(userRepository.findUserById(userId));
        }
        else {
            return ResponseEntity.badRequest().body(new MessageResponse("user not exits!"));
        }
    }
}
