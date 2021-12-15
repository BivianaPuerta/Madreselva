package com.madreselva.reto3.service;

import java.util.List;
import java.util.Optional;

import com.madreselva.reto3.model.Order;
import com.madreselva.reto3.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    public Optional<Order> getOrder(int id) {
        return orderRepository.getOrder(id);
    }

    public Order create(Order order) {
        
        Optional<Order> orderIdMaxima = orderRepository.lastUserId();
        
        if (order.getId() == null) {
            if (orderIdMaxima.isEmpty())
                order.setId(1);
            else
                order.setId(orderIdMaxima.get().getId() + 1);
        }
        
        Optional <Order> exist = orderRepository.getOrder(order.getId());
        if (exist.isEmpty()){
                return orderRepository.create(order);
            }
            else{
                return order;
            }
    }

    public Order update (Order order){
        if (order.getId() !=null){
            Optional <Order> orderDateBase = orderRepository.getOrder(order.getId());
            if(!orderDateBase.isEmpty()){
                if(order.getStatus() !=null){
                    orderDateBase.get().setStatus(order.getStatus());
                }
                
                orderRepository.update(orderDateBase.get());
                return orderDateBase.get();
            } 
            else{
                return order;
            }
        } 
        else {
            return order;
        }
    }

    public boolean deleteOrder(int id){
        Optional <Order> exist= orderRepository.getOrder(id);
        if(!exist.isEmpty()){
            orderRepository.delete(exist.get());

            return true;
        }
        return false;
    }

    public List<Order> findByZone(String zona) {
        return orderRepository.findByZone(zona);
    }
    
    public List<Order> ordersSalesManByID(Integer id) {
        return orderRepository.ordersSalesManByID(id);
     }
     
     public List<Order> ordersSalesManByState(String state, Integer id) {
         return orderRepository.ordersSalesManByState(state,id);
     }
     
     
     public List<Order> ordersSalesManByDate(String dateString, Integer id){
         return orderRepository.ordersSalesManByDate(dateString, id);
     }
}

