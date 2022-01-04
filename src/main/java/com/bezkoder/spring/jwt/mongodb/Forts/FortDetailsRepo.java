package com.bezkoder.spring.jwt.mongodb.Forts;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FortDetailsRepo extends MongoRepository<FortDetails,Long> {
    FortDetails findById(int id);

    FortDetails findByFortId(int id);

    FortDetails findFortDetailsByFortId(int id);

    FortDetails findFortDetailsByFort(Fort fort);
}
