package com.bezkoder.spring.jwt.mongodb.city.En;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepo extends MongoRepository<City,Long> {
    City findById(int cid);
    List<City> findAllCitiesByState(State state);
}
