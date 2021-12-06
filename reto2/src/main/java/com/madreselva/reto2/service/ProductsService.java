package com.madreselva.reto2.service;

import java.util.List;
import java.util.Optional;

import com.madreselva.reto2.model.Products;
import com.madreselva.reto2.repository.ProductsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {
    @Autowired
    private ProductsRepository cosmeticRepository;

    public List<Products> getAll(){
        return cosmeticRepository.getAll();
    }

    public Optional<Products> getCosmetic(String reference){
        return cosmeticRepository.getCosmetic(reference);
    }

    public Products create(Products cosmetic){
        if (cosmetic.getReference() ==null){
            return cosmetic;
        }
        else{
            return cosmeticRepository.create(cosmetic);
        }
    }

    public Products update (Products cosmetic){
        if (cosmetic.getReference() !=null){
            Optional <Products> cosmeticDateBase = cosmeticRepository.getCosmetic(cosmetic.getReference());
            if(!cosmeticDateBase.isEmpty()){
                if(cosmetic.getBrand() !=null){
                    cosmeticDateBase.get().setBrand(cosmetic.getBrand());
                }
                if (cosmetic.getCategory()!=null){
                    cosmeticDateBase.get().setCategory(cosmetic.getCategory());
                }
                if (cosmetic.getName()!=null){
                    cosmeticDateBase.get().setName(cosmetic.getName());
                }
                if (cosmetic.getDescription()!=null){
                    cosmeticDateBase.get().setDescription(cosmetic.getDescription());
                }
                if (cosmetic.getPrice()!=0.0){
                    cosmeticDateBase.get().setPrice(cosmetic.getPrice());
                }
                if (cosmetic.getQuantity()!=0){
                    cosmeticDateBase.get().setQuantity(cosmetic.getQuantity());
                }
                if (cosmetic.getPhotography()!=null){
                    cosmeticDateBase.get().setPhotography(cosmetic.getPhotography());
                }
                cosmeticDateBase.get().setAvailability(cosmetic.getAvailability());
                
                cosmeticRepository.update(cosmeticDateBase.get());
                    return cosmeticDateBase.get();
            }else{
                return cosmetic;
            }
        }return cosmetic;
    }

    public boolean deleteProducts(String reference){
        Optional <Products> cosmetic= cosmeticRepository.getCosmetic(reference);
        if(!cosmetic.isEmpty()){
            cosmeticRepository.delete(cosmetic.get());

            return true;
        }
        return false;
    }

}
