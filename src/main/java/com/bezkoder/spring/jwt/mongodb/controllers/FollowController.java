package com.bezkoder.spring.jwt.mongodb.controllers;

import com.bezkoder.spring.jwt.mongodb.models.User;
import com.bezkoder.spring.jwt.mongodb.payload.response.MessageResponse;
import com.bezkoder.spring.jwt.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/follow")
public class FollowController {
    @Autowired
    private final UserRepository userRepository;

    public FollowController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/{userId}/f")
    public ResponseEntity followRequest(@PathVariable String userId){
        if(userRepository.existsById(userId)) {
            User user = userRepository.findUserById(userId);
//            List<String> follow = user.getFollower();
            if (user.getFollowing()==null){
                List<String> follow = new ArrayList<>();
                follow.add("hi4");
                user.setFollower(follow);
                userRepository.save(user);
                return ResponseEntity.ok(new MessageResponse("DONE.."));
            }
            else {
                List<String> follow = user.getFollower();
                follow.add("hi4");
                userRepository.save(user);
                return ResponseEntity.ok(new MessageResponse("done.."));
            }
        }
        else {
            return ResponseEntity.badRequest().body(new MessageResponse("User does not exits!"));
        }
    }
}
