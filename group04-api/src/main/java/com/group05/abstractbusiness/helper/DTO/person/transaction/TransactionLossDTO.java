package com.group05.abstractbusiness.helper.DTO.person.transaction;

import com.group05.abstractbusiness.modules.model.Cart;

import lombok.Data;

@Data
public class TransactionLossDTO {
    Double value;
    int discount;
    Cart cart;
}
