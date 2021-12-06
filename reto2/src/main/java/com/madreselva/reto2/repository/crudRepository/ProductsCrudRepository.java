package com.madreselva.reto2.repository.crudRepository;

import com.madreselva.reto2.model.Products;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductsCrudRepository  extends MongoRepository<Products, String> {
    
    
}
