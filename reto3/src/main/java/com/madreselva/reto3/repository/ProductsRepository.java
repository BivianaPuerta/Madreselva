package com.madreselva.reto3.repository;

import java.util.List;
import java.util.Optional;

import com.madreselva.reto3.model.Products;
import com.madreselva.reto3.repository.CrudRepository.ProductsCrudRepository;

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
    
}