package com.bezkoder.spring.jwt.mongodb.city.En;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepo extends MongoRepository<State,Long> {
    State findById(int sid);
}
