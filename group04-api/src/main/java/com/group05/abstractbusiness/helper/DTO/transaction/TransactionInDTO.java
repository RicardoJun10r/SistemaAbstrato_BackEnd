package com.group05.abstractbusiness.helper.DTO.transaction;

import com.group05.abstractbusiness.modules.model.Person.Supplier;
import lombok.Data;
import com.group05.abstractbusiness.modules.model.Cart;

@Data
public class TransactionInDTO {
    Double value;
    int discount;
    Supplier supplier;
    Cart cart;
}
