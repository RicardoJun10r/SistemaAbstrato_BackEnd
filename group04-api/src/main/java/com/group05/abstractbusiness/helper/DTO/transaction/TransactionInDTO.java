package com.group05.abstractbusiness.helper.DTO.transaction;

import lombok.Data;
import com.group05.abstractbusiness.modules.model.Cart;
import com.group05.abstractbusiness.modules.model.Person.Suppliers.Supplier;

@Data
public class TransactionInDTO {
    Double value;
    int discount;
    Supplier supplier;
    Cart cart;
}
