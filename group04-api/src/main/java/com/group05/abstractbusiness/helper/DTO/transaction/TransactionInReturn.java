package com.group05.abstractbusiness.helper.DTO.transaction;

import java.util.UUID;

import com.group05.abstractbusiness.modules.model.Cart;
import com.group05.abstractbusiness.modules.model.Person.Suppliers.Supplier;

import lombok.Data;

@Data
public class TransactionInReturn {
    UUID id;
    Double value;
    int discount;
    Cart cart;
    Supplier supplier;
}
