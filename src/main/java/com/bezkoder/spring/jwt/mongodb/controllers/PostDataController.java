package com.bezkoder.spring.jwt.mongodb.controllers;

import com.bezkoder.spring.jwt.mongodb.models.PostData;
import com.bezkoder.spring.jwt.mongodb.models.User;
import com.bezkoder.spring.jwt.mongodb.payload.request.PostUser;
import com.bezkoder.spring.jwt.mongodb.repository.PostDataRepository;
import com.bezkoder.spring.jwt.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostDataController {
    @Autowired
    private final PostDataRepository postDataRepository;
    @Autowired
    private final UserRepository userRepository;

    public PostDataController(PostDataRepository postDataRepository, UserRepository userRepository) {
        this.postDataRepository = postDataRepository;
        this.userRepository = userRepository;
    }

    @PostMapping(value = "/{userId}/add")
    public String createPost(@PathVariable String userId,@RequestBody PostData postData){
        User user=userRepository.findUserById(userId);
        PostUser postUser=new PostUser();
        postUser.setUserId(user.getId());
        postUser.setFirstname(user.getFirstname());
        postUser.setLastname(user.getLastname());
        postData.setPostUser(postUser);
        postData.setCreatedDate(java.time.LocalDateTime.now());
        PostData insertPost=postDataRepository.insert(postData);
        return "Post created: " + insertPost.getPostId();
    }

    @GetMapping(value = "/{userId}/posts")
    public List<PostData> getAllPostsByUserId(@PathVariable String userId){
        return postDataRepository.findAllByUserId(userId);
    }

    @GetMapping(value = "/allposts")
    public List<PostData> getAllPosts(){ 
        return postDataRepository.findAll(); }
}
