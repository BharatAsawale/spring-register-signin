package com.bezkoder.spring.jwt.mongodb.Forts.Mar;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FortMarDetailsRepo extends MongoRepository<FortMarDetails,Long> {
    FortMarDetails findById(int id);

    FortMarDetails findByFortId(int id);
}
