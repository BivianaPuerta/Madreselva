package com.madreselva.reto3.repository.CrudRepository;

import com.madreselva.reto3.model.Products;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductsCrudRepository extends MongoRepository<Products, String>{

}
    

