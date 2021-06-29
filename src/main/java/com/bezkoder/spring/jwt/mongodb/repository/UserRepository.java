package com.bezkoder.spring.jwt.mongodb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bezkoder.spring.jwt.mongodb.models.User;

public interface UserRepository extends MongoRepository<User, String> {

  Boolean existsByEmail(String email);

  Optional<User> findUserByEmail(String email);

  User findUserById(String userId);

  boolean existsById(String userId);
}
