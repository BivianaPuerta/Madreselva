package com.madreselva.reto3.repository;

import java.util.List;
import java.util.Optional;

import com.madreselva.reto3.model.Order;
import com.madreselva.reto3.repository.CrudRepository.OrderCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
    
    @Autowired
    private OrderCrudRepository orderCrudRepository;

    public List<Order> getAll() {
        return (List<Order>) orderCrudRepository.findAll();
    }

    public Optional<Order> getOrder(int id) {
        return orderCrudRepository.findById(id);
    }

    public Order create(Order order) {
        return orderCrudRepository.save(order);
    }

    public Order update(Order order) {
       return orderCrudRepository.save(order);
    }

    public void delete(Order order) {
        orderCrudRepository.delete(order);
    }
    
    public Optional<Order> lastUserId(){
        return orderCrudRepository.findTopByOrderByIdDesc();
    }
    
    public List<Order> findByZone(String zona) {
        return orderCrudRepository.findByZone(zona);
    }
    
}
