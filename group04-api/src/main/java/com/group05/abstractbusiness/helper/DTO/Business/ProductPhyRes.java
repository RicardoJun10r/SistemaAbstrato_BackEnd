package com.group05.abstractbusiness.helper.DTO.Business;

import com.group05.abstractbusiness.helper.DTO.person.supplier.SupplierRes;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class ProductPhyRes extends ProductRes {
    
    Float weight;

    Float height;

    Float width;

    Integer quantity;

    SupplierRes supplier;

}