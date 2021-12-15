package com.madreselva.reto3.repository.CrudRepository;

import java.util.Optional;

import com.madreselva.reto3.model.User;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserCrudRepository extends MongoRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email , String passwordl);
    
    Optional <User> findTopByOrderByIdDesc();
}
