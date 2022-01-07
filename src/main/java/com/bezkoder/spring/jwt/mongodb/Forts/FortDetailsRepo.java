package com.bezkoder.spring.jwt.mongodb.Forts;

import com.bezkoder.spring.jwt.mongodb.Forts.FortDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FortDetailsRepo extends MongoRepository<FortDetails,Long> {

    FortDetails findByFortId(int id);
}