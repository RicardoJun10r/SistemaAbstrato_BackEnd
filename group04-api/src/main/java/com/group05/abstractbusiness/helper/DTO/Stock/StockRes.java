package com.group05.abstractbusiness.helper.DTO.Stock;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@MappedSuperclass
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class StockRes {

    UUID id;

    String name;
    
    Integer quantity;
    
    LocalDate createdAt;
    
    LocalDate updatedAt;

}
