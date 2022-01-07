package com.bezkoder.spring.jwt.mongodb.city.Mar;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityMarRepo extends MongoRepository<CityMar,Long> {

    List<CityMar> findAllByState(StateMar stateMar);
}
