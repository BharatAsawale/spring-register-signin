package com.bezkoder.spring.jwt.mongodb.Forts;

import com.bezkoder.spring.jwt.mongodb.Forts.FortDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FortDetailsRepo extends MongoRepository<FortDetails,Long> {
//    List<FortDetails> findByFortId(int id);

    FortDetails findByFortId(int id);
}