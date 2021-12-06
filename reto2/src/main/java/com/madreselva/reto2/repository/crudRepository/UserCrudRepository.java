package com.madreselva.reto2.repository.crudRepository;

import java.util.Optional;

import com.madreselva.reto2.model.User;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserCrudRepository extends MongoRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email , String passwordl);
}
