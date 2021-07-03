package com.bezkoder.spring.jwt.mongodb.controllers;

import com.bezkoder.spring.jwt.mongodb.models.User;
import com.bezkoder.spring.jwt.mongodb.payload.request.FollowRequest;
import com.bezkoder.spring.jwt.mongodb.payload.response.FollowResponse;
import com.bezkoder.spring.jwt.mongodb.payload.response.MessageResponse;
import com.bezkoder.spring.jwt.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/follow")
public class FollowController {
    @Autowired
    private final UserRepository userRepository;

    public FollowController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(value = "/")
    public ResponseEntity followRequest(@RequestBody FollowRequest followRequest){
        if(followRequest.getFollower()==followRequest.getFollowing()){
            return ResponseEntity.badRequest().body(new MessageResponse("trying to follow itself!"));
        }
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

    @PostMapping(value = "/unfollow")
    public ResponseEntity unfollowPostRequest(@RequestBody FollowRequest followRequest){
        if(followRequest.getFollower()==followRequest.getFollowing()){
            return ResponseEntity.badRequest().body(new MessageResponse("trying to unfollow itself!"));
        }
        if(userRepository.existsById(followRequest.getFollower())){
            try{
                User user=userRepository.findUserById(followRequest.getFollower());
                List<String> following = user.getFollowing();
                if(following.contains(followRequest.getFollowing())){
                    return ResponseEntity.badRequest().body(new MessageResponse("not following"));
                }
                else {
                    following.remove(followRequest.getFollowing());
                    user.setFollowing(following);
                    userRepository.save(user);
                    User user1 = userRepository.findUserById(followRequest.getFollowing());
                    List<String> follower = user1.getFollower();
                    if(follower.contains(followRequest.getFollower())){
                        return ResponseEntity.badRequest().body(new MessageResponse("not follower"));
                    }
                    else {
                        follower.remove(followRequest.getFollower());
                        user1.setFollower(follower);
                        userRepository.save(user1);
                        return ResponseEntity.ok().body(new MessageResponse("done"));
                    }
                }
            }
            catch (NullPointerException e){
                User user = userRepository.findUserById(followRequest.getFollower());
                List<String> following = new ArrayList<>();
                following.remove(followRequest.getFollowing());
                user.setFollowing(following);
                userRepository.save(user);
                User user1=userRepository.findUserById(followRequest.getFollowing());
                List<String> follower = new ArrayList<>();
                follower.remove(followRequest.getFollower());
                user1.setFollower(follower);
                userRepository.save(user1);
                return ResponseEntity.ok().body(new MessageResponse("done"));
            }
        }
        else
            return ResponseEntity.badRequest().body(new MessageResponse("User not found.."));
    }

    @GetMapping(value = "/getfollowings/{userid}")
    public ResponseEntity<?> getFollowings(@PathVariable String userid){
        if(userRepository.existsById(userid)) {
            User user = userRepository.findUserById(userid);
            List<String> list=user.getFollowing();
            List<HashMap<String, String>> ls=new ArrayList<>();
            for(String users:list){
                HashMap<String, String> flw = new HashMap<>();
                User user1= userRepository.findUserById(users);
                flw.put("userid",users);
                flw.put("firstname",user1.getFirstname());
                flw.put("lastname",user1.getLastname());
                flw.put("profilepic",user1.getProfilepic());
                ls.add(flw);
            }
            return ResponseEntity.ok(new FollowResponse(
                    userid,
                    ls
            ));
        }
        return ResponseEntity.badRequest().body(new MessageResponse("User not found.."));
    }
}
