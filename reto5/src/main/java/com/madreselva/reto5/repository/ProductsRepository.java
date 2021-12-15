package com.madreselva.reto5.repository;

import java.util.List;
import java.util.Optional;

import com.madreselva.reto5.model.Products;
import com.madreselva.reto5.repository.crudRepository.ProductsCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductsRepository {
    
    @Autowired
    private ProductsCrudRepository productsCrudRepository;

    public List<Products> getAll(){
        return productsCrudRepository.findAll();
    }

    public Optional<Products> getCosmetic(String reference){
        return productsCrudRepository.findById(reference);
    }

    public Products create(Products cosmetic){
        return productsCrudRepository.save(cosmetic);
    }

    public Products update(Products cosmetic){
         return productsCrudRepository.save(cosmetic);
    }

    public void delete(Products cosmetic){
        productsCrudRepository.delete(cosmetic);
    }

    public List<Products> productsByPrice(double precio){
        return productsCrudRepository.findByPriceLessThanEqual(precio);
    }
    
    public List<Products> findByDescriptionLike(String description){
	return productsCrudRepository.findByDescriptionLike(description);
    }
}
