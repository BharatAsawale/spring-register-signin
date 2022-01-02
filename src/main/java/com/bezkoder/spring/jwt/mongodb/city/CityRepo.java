package com.bezkoder.spring.jwt.mongodb.city;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepo extends MongoRepository<City,Long> {
    List<City> findByState(String state);

    List<City> findCitiesByState(Long stateId);

    List<City> findCitiesByStateName(String state);
}
