package com.bezkoder.spring.jwt.mongodb.city.Mar;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateMarRepo extends MongoRepository<StateMar,Long> {
    StateMar findById(int sid);
}
