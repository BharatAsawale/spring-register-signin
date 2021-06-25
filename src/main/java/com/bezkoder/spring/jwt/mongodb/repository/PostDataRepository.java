package com.bezkoder.spring.jwt.mongodb.repository;

import com.bezkoder.spring.jwt.mongodb.models.PostData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostDataRepository extends MongoRepository<PostData,String> {

    List<PostData> findAllByUserId(String userId);

    List<PostData> findAllPostsByUserId(String userId);
}
