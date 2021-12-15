package com.madreselva.reto5.repository.crudRepository;

import java.util.List;
import java.util.Optional;

import com.madreselva.reto5.model.Order;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface OrderCrudRepository extends MongoRepository<Order, Integer> {
    @Query("{'salesMan.zone':?0}")
    List <Order> findByZone(final String zone);

    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);
    
    Optional<Order> findTopByOrderByIdDesc();
}
