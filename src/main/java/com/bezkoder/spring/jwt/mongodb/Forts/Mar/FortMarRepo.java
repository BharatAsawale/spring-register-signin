package com.bezkoder.spring.jwt.mongodb.Forts.Mar;

import com.bezkoder.spring.jwt.mongodb.city.Mar.CityMar;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FortMarRepo extends MongoRepository<FortMar,Long> {
    FortMar findById(int id);

    List<FortMar> findByCity(CityMar cityMar);
}