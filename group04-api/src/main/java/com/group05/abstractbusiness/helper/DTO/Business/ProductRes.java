package com.group05.abstractbusiness.helper.DTO.Business;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@MappedSuperclass
@EqualsAndHashCode
@Data
public abstract class ProductRes {

    UUID id;

    String name;
    
    String description;
    
    Boolean status;
    
    Double cost;
    
    Double price;
    
    String brand;
    
    String category;
    
    String subCategory;
    
    String image;
    
    LocalDate createdAt;
    
    LocalDate updatedAt;
    
    LocalDate deletedAt;

}
