package com.madreselva.reto5.repository.crudRepository;

import java.util.List;

import com.madreselva.reto5.model.Products;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ProductsCrudRepository extends MongoRepository<Products, String> {
    
    public List<Products> findByPriceLessThanEqual(double precio);
    
    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Products> findByDescriptionLike(String description);
}
