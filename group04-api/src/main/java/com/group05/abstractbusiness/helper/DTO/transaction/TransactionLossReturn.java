package com.group05.abstractbusiness.helper.DTO.transaction;

import java.util.UUID;

import com.group05.abstractbusiness.modules.model.Cart;

import lombok.Data;

@Data
public class TransactionLossReturn {
    UUID id;
    Double value;
    int discount;
    Cart cart;
}
