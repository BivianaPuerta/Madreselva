package com.madreselva.reto5.repository;

import java.util.List;
import java.util.Optional;

import com.madreselva.reto5.model.User;
import com.madreselva.reto5.repository.crudRepository.UserCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Biviana Puerta
 */
@Repository
public class UserRepository {
    
    @Autowired

        /**
        * userCrudRepository
        */
        private UserCrudRepository userCrudRepository;

        /**
         * Optional <User>
         * @param id
         * @return integer
         */
        public Optional <User> getUser(int id){
            return userCrudRepository.findById(id);
        }

        /**
         * List User
         * @return array
         */
        public List <User> getAll(){
            return userCrudRepository.findAll();
        }

        /**
         * emailexist
         * @param email
         * @return String
         */
        public boolean emailexist(String email){
            Optional<User> users= userCrudRepository.findByEmail(email);
            
            return !users.isEmpty();
        }

        /**
         * userAuthentication
         * @param email
         * @param password
         * @return String
         */
        public Optional <User> userAuthentication(String email, String password){
            return userCrudRepository.findByEmailAndPassword(email, password);
        }

        /**
         * create User
         * @param user
         * @return user
         */
        public User create(User user){
            return userCrudRepository.save(user);
        }

        /**
         * update User
         * @param user
         * @return user
         */
        public User update(User user){
            return userCrudRepository.save(user);
        }

        /**
         * delete
         * @param user
         */
        public void delete(User user){
            userCrudRepository.delete(user);
        }


        /**
         * lastUserId
         * @return user
         */
        public Optional<User> lastUserId(){
            return userCrudRepository.findTopByOrderByIdDesc();
        }


        /**
         * User
         * @param month
         * @return String
         */
        public List<User> listBirthtDayMonth(String month){
            return userCrudRepository.findByMonthBirthtDay(month);
        }
}
