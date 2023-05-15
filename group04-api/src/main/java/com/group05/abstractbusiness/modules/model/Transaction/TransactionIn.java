package com.group05.abstractbusiness.modules.model.Transaction;


import com.group05.abstractbusiness.modules.model.Cart;
import com.group05.abstractbusiness.modules.model.Person.Supplier;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("I")
public class TransactionIn extends Transaction {

	// Alterar JOIN TABLE SUPPLIER
	@ManyToOne
	@JoinColumn(name = "supplier_id")
	private Supplier supplier;


	
	// @Column(name = "document")
	// private Receipter document;

	public TransactionIn(Double value, int discount, Supplier supplier, Cart cart) {
		super(value, discount, cart);
		this.supplier = supplier;
	}


}
