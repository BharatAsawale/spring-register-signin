package com.bezkoder.spring.jwt.mongodb.city;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepo extends MongoRepository<State,Long> {
}
