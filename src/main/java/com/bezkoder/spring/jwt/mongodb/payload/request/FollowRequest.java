package com.bezkoder.spring.jwt.mongodb.payload.request;

public class FollowRequest {
    private String following;
    private String follower;

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }
}
