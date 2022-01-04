package com.bezkoder.spring.jwt.mongodb.Forts;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FortRepo extends MongoRepository<Fort,Long> {

    Fort findById(int id);
}
