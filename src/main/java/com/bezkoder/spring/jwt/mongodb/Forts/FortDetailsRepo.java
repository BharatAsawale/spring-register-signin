package com.bezkoder.spring.jwt.mongodb.Forts;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FortDetailsRepo extends MongoRepository<FortDetails,Long> {

    FortDetails findByFortId(int id);
}