package com.group05.abstractbusiness.helper.DTO.transaction;

import com.group05.abstractbusiness.modules.model.Cart;
import com.group05.abstractbusiness.modules.model.Person.Customer;

import lombok.Data;

@Data
public class TransactionOutDTO {
    Double value;
    int discount;
    Customer customer;
    Cart cart;
}
