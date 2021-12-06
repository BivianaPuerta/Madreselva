package com.madreselva.reto2.service;

import java.util.List;
import java.util.Optional;

import com.madreselva.reto2.model.User;
import com.madreselva.reto2.repository.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.getAll();
    }

    public Optional<User> getUsers(int id){
        return userRepository.getUser(id);
    }

    public boolean emailexist(String email){
        return userRepository.emailexist(email);
    }

    public User userAuthentication(String email, String password){
        Optional <User> users= userRepository.userAuthentication(email, password);

        if(users.isEmpty()){
            return new User();
        }
        else{
            return users.get();
        }
    }

    public User create(User user){
        if (user.getId()==null){
            return user;
        }
        else{
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
    }

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

    public boolean deleteUser(int id){
        Optional <User> exist= userRepository.getUser(id);
        if(!exist.isEmpty()){
            userRepository.delete(exist.get());

            return true;
        }
        return false;
    }
}
