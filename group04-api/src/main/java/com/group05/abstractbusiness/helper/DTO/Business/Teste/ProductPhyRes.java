package com.group05.abstractbusiness.helper.DTO.Business.Teste;

import com.group05.abstractbusiness.modules.model.Person.Supplier;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class ProductPhyRes extends ProductRes {
    
    Float weight;

    Float height;

    Float width;

    Integer quantity;

    Supplier supplier;

}