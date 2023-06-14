package com.group05.abstractbusiness.modules.model.Transaction;

import com.group05.abstractbusiness.modules.model.Cart;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("O")
public class TransactionOut extends Transaction{

	@Column(name = "client_name")
	private String customer;


	//TO-DO
	// @Column(name = "document")
	// private Receipter document;

	public TransactionOut( Double value, int discount, String customer, Cart cart) {
		super(value, discount, cart);
		this.customer = customer;
	}
}
