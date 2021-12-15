package com.madreselva.reto3.repository;

import java.util.List;
import java.util.Optional;

import com.madreselva.reto3.model.User;
import com.madreselva.reto3.repository.CrudRepository.UserCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
        @Autowired
        private UserCrudRepository userCrudRepository;

        public Optional <User> getUser(int id){
            return userCrudRepository.findById(id);
        }
        
        public List <User> getAll(){
            return userCrudRepository.findAll();
        }

        public boolean emailexist(String email){
            Optional<User> users= userCrudRepository.findByEmail(email);
            
            return !users.isEmpty();
        }

        public Optional <User> userAuthentication(String email, String password){
            return userCrudRepository.findByEmailAndPassword(email, password);
        }

        public User create(User user){
            return userCrudRepository.save(user);
        }

        public User update(User user){
            return userCrudRepository.save(user);
        }

        public void delete(User user){
            userCrudRepository.delete(user);
        }

        public Optional<User> lastUserId(){
            return userCrudRepository.findTopByOrderByIdDesc();
        }
}
