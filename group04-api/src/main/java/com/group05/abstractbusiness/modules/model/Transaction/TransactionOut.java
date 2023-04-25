package com.group05.abstractbusiness.modules.model.Transaction;

import com.group05.abstractbusiness.modules.model.Cart;
import com.group05.abstractbusiness.modules.model.Person.Customer;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("O")
public class TransactionOut extends Transaction{

	// Alterar JOIN TABLE CUSTOMER 
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	// @Column(name = "document")
	// private Receipter document;

	public TransactionOut( long value, int discount, Customer customer, Cart cart) {
		super(value, discount, cart);
		this.customer = customer;
	}

	public TransactionOut() {}

}
