package com.group05.abstractbusiness.helper.DTO.Stock;

import java.time.LocalDate;
import java.util.List;

import com.group05.abstractbusiness.helper.DTO.Business.ProductRes;
import com.group05.abstractbusiness.utils.Enums.TipoProduto;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@MappedSuperclass
@EqualsAndHashCode
@Data
public class StockRes {

    String name;
    
    Integer quantity;
    
    LocalDate createdAt;
    
    LocalDate updatedAt;

    String address;

    TipoProduto tipoProduto;

    List<ProductRes> produtosFisicos;

}
