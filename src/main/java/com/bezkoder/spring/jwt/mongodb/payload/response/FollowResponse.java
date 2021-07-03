package com.bezkoder.spring.jwt.mongodb.payload.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FollowResponse {
    private String userid;
    private List<HashMap<String, String>> follows;

    public FollowResponse(String userid, List<HashMap<String, String>> follows) {
        this.userid = userid;
        this.follows = follows;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public List<HashMap<String, String>> getFollows() {
        return follows;
    }

    public void setFollows(List<HashMap<String, String>> follows) {
        this.follows = follows;
    }
}
