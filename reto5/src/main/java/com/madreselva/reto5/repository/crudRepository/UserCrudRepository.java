package com.madreselva.reto5.repository.crudRepository;

import java.util.List;
import java.util.Optional;

import com.madreselva.reto5.model.User;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserCrudRepository  extends MongoRepository<User, Integer>{
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email , String passwordl);
    
    Optional <User> findTopByOrderByIdDesc();

    List<User> findByMonthBirthtDay(String month);
}
