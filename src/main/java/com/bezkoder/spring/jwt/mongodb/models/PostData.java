package com.bezkoder.spring.jwt.mongodb.models;

import com.bezkoder.spring.jwt.mongodb.payload.request.PostUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Document(collection = "postdata")
public class PostData {
    @Id
    private String postId;
    @JsonIgnore
    private String userId;
    private String caption;
    private String imgUrl;
    @Column(name="createdDate", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdDate;

    PostUser postUser;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public PostUser getPostUser() {
        return postUser;
    }

    public void setPostUser(PostUser postUser) {
        this.postUser = postUser;
    }
}
