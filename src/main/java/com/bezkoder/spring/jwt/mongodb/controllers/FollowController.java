package com.bezkoder.spring.jwt.mongodb.controllers;

import com.bezkoder.spring.jwt.mongodb.models.User;
import com.bezkoder.spring.jwt.mongodb.payload.request.FollowRequest;
import com.bezkoder.spring.jwt.mongodb.payload.response.MessageResponse;
import com.bezkoder.spring.jwt.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/{userId}/{userId1}")
    public ResponseEntity followRequest(@PathVariable String userId,@PathVariable String userId1){
        if(userRepository.existsById(userId)){
            try {
                User user = userRepository.findUserById(userId);
                List<String> following = user.getFollowing();
                if(following.contains(userId1)){
                    return ResponseEntity.badRequest().body(new MessageResponse("already following"));
                }
                else {
                    following.add(userId1);
                    user.setFollowing(following);
                    userRepository.save(user);
                    User user1 = userRepository.findUserById(userId1);
                    List<String> follower = user1.getFollower();
                    if(follower.contains(userId)){
                        return ResponseEntity.badRequest().body(new MessageResponse("already follower"));
                    }
                    else {
                        follower.add(userId);
                        user1.setFollower(follower);
                        userRepository.save(user1);
                        return ResponseEntity.ok().body(new MessageResponse("done"));
                    }
                }
            }
            catch (NullPointerException e){
                User user = userRepository.findUserById(userId);
                List<String> following = new ArrayList<>();
                following.add(userId1);
                user.setFollowing(following);
                userRepository.save(user);
                User user1=userRepository.findUserById(userId1);
                List<String> follower = new ArrayList<>();
                follower.add(userId);
                user1.setFollower(follower);
                userRepository.save(user1);
                return ResponseEntity.ok().body(new MessageResponse("done"));
            }
        }
        else
            return ResponseEntity.badRequest().body(new MessageResponse("User not found.."));
    }

    @PostMapping(value = "/")
    public ResponseEntity followPostRequest(@RequestBody FollowRequest followRequest){
        if(userRepository.existsById(followRequest.getFollower())){
            try{
                User user=userRepository.findUserById(followRequest.getFollower());
                List<String> following = user.getFollowing();
                if(following.contains(followRequest.getFollowing())){
                    return ResponseEntity.badRequest().body(new MessageResponse("already following"));
                }
                else {
                    following.add(followRequest.getFollowing());
                    user.setFollowing(following);
                    userRepository.save(user);
                    User user1 = userRepository.findUserById(followRequest.getFollowing());
                    List<String> follower = user1.getFollower();
                    if(follower.contains(followRequest.getFollower())){
                        return ResponseEntity.badRequest().body(new MessageResponse("already follower"));
                    }
                    else {
                        follower.add(followRequest.getFollower());
                        user1.setFollower(follower);
                        userRepository.save(user1);
                        return ResponseEntity.ok().body(new MessageResponse("done"));
                    }
                }
            }
            catch (NullPointerException e){
                User user = userRepository.findUserById(followRequest.getFollower());
                List<String> following = new ArrayList<>();
                following.add(followRequest.getFollowing());
                user.setFollowing(following);
                userRepository.save(user);
                User user1=userRepository.findUserById(followRequest.getFollowing());
                List<String> follower = new ArrayList<>();
                follower.add(followRequest.getFollower());
                user1.setFollower(follower);
                userRepository.save(user1);
                return ResponseEntity.ok().body(new MessageResponse("done"));
            }
        }
        else
            return ResponseEntity.badRequest().body(new MessageResponse("User not found.."));
    }

}
