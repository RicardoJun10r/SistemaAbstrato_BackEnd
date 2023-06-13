package com.group05.abstractbusiness.helper.DTO.Business;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ProductReturn {
    
    private String name;
    
    private String description;
    
    private Boolean status;
    
    private Double cost;
    
    private Double price;
    
    private String brand;
    
    private String category;
    
    private String subCategory;
    
    private String image;
    
    private LocalDate createdAt;
    
    private LocalDate updatedAt;
    
    private LocalDate deletedAt;
    
}
