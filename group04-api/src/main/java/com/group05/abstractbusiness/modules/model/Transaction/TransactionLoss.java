package com.group05.abstractbusiness.modules.model.Transaction;

import com.group05.abstractbusiness.modules.model.Cart;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("L")
public class TransactionLoss extends Transaction{
    public TransactionLoss(long value, int discount, Cart cart){
        super(value, discount, cart);
    }
}
