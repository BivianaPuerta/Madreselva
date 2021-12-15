package com.madreselva.reto5.service;

import java.util.List;
import java.util.Optional;

import com.madreselva.reto5.model.User;
import com.madreselva.reto5.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
     /**
     * class user
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * 
     * List User
     * @return List
     */
    public List<User> getAll(){
        return userRepository.getAll();
    }
    /**
     * Optional User
     * @param id
     * @return integer 
     */
    public Optional<User> getUsers(int id){
        return userRepository.getUser(id);
    }
    /**
     * boolean emailexist
     * @return boolean
     */
    public boolean emailexist(String email){
        return userRepository.emailexist(email);
    }

    /**
     * userAuthentication
     * @param email
     * @param password
     * @return String
     */
    public User userAuthentication(String email, String password){
        Optional <User> users= userRepository.userAuthentication(email, password);

        if(users.isEmpty()){
            return new User();
        }
        else{
            return users.get();
        }
    }


    /**
     * User create
     * @param user
     * @return user
     */
    public User create(User user){

        Optional<User> userIdMaximo = userRepository.lastUserId();
        
            if (user.getId() == null) {
                if (userIdMaximo.isEmpty())
                    user.setId(1);
                else
                    user.setId(userIdMaximo.get().getId() + 1);
        }
            Optional <User> exist = userRepository.getUser(user.getId());
            if (exist.isEmpty()){
                if(emailexist(user.getEmail())==false){
                    return userRepository.create(user);
                }
                else{
                    return user;
                }
            }
            else{
                return user;
            }
        }

        /**
         * User update
         * @param user
         * @return atributos user
         */
    public User update (User user){
        if (user.getId() !=null){
            Optional <User> userDateBase = userRepository.getUser(user.getId());
            if(!userDateBase.isEmpty()){
                if(user.getIdentification() !=null){
                    userDateBase.get().setIdentification(user.getIdentification());
                }
                if (user.getName()!=null){
                    userDateBase.get().setName(user.getName());
                }
                if (user.getMonthBirthtDay()!=null){
                    userDateBase.get().setMonthBirthtDay(user.getMonthBirthtDay());
                }
                if (user.getAddress()!=null){
                    userDateBase.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone()!=null){
                    userDateBase.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail()!=null){
                    userDateBase.get().setEmail(user.getEmail());
                }
                if (user.getPassword()!=null){
                    userDateBase.get().setPassword(user.getPassword());
                }
                if (user.getZone()!=null){
                    userDateBase.get().setZone(user.getZone());
                }
                if (user.getType()!=null){
                    userDateBase.get().setType(user.getType());
                }
                userRepository.update(userDateBase.get());
                    return userDateBase.get();
            }else{
                return user;
            }
        }return user;
    }
    /**
     * boolean deleteUser
     * @param id
     * @return boolean
     */

    public boolean deleteUser(int id){
        Optional <User> exist= userRepository.getUser(id);
        if(!exist.isEmpty()){
            userRepository.delete(exist.get());

            return true;
        }
        return false;
    }
    
    public List<User> listBirthtDayMonth(String month){
        return userRepository.listBirthtDayMonth(month);
    }
}
