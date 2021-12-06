package com.madreselva.reto2.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "cosmetics")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Products {
    @Id
    private String reference;
    private String brand;
    private String category;
    private String name;
    private String description;
    private Boolean availability;
    private Double price;
    private Integer quantity;
    private String photography;
}
