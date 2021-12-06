package com.madreselva.reto2.web;

import java.util.List;

import com.madreselva.reto2.model.User;
import com.madreselva.reto2.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Biviana Puerta
 */
@RestController
@RequestMapping("/api/user/")
@CrossOrigin("*")

/**
 * class UserController
 */
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * Get Mapping
     * @return userService
     */
    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
    }

    /**
     * GetMapping
     * @param email
     * @return boolean 
     */
    @GetMapping("/emailexist/{email}")
    public boolean emailexist(@PathVariable("email") String email){
        return userService.emailexist(email);
    }

    /**
     * GetMapping
     * @param email
     * @param password
     * @return userAuthentication
     */
    @GetMapping("/{email}/{password}")
    public User userAuthentcation(@PathVariable("email")String email, @PathVariable("password")String password){
        return userService.userAuthentication(email, password);
    }

    /**
     * PostMapping
     * @param user
     * @return userService
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    /**
     * PutMapping
     * @param user
     * @return userService
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    /**
     * DeleteMapping
     * @param id
     * @return userService
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteUser(@PathVariable("id")int id){
        return userService.deleteUser(id);
    }

}
