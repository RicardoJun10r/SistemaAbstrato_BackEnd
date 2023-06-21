package com.group05.abstractbusiness.helper.DTO.Stock;

import java.time.LocalDate;
import java.util.List;

import com.group05.abstractbusiness.helper.DTO.Business.ProductRes;
import com.group05.abstractbusiness.modules.model.Person.Users.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDTO {
    
    String name;
    
    Integer quantity;
    
    LocalDate createdAt;
    
    LocalDate updatedAt;

    String address;

    List<ProductRes> produtosFisicos;

    User user;
    
}
