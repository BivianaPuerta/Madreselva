package com.madreselva.reto2.web;

import java.util.List;
import java.util.Optional;

import com.madreselva.reto2.model.Products;
import com.madreselva.reto2.service.ProductsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/cosmetics")
@CrossOrigin("*")
public class ProductsController {
    @Autowired
    private ProductsService productsService;

    @GetMapping("/all")
    public List<Products> getAll(){
        return productsService.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Products> getCosmetic(@PathVariable("reference")String reference){
        return productsService.getCosmetic(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Products create(@RequestBody Products cosmetic){
        return productsService.create(cosmetic);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Products update(@RequestBody Products cosmetic){
        return productsService.update(cosmetic);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteProducts(@PathVariable("reference")String reference){
        return productsService.deleteProducts(reference);
    }

}
    
    

