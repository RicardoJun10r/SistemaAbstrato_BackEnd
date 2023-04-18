package com.group05.abstractbusiness.model.Transaction;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class TransactionOut extends Transaction {

	// Alterar JOIN TABLE CUSTOMER
	@Column(name = "customerId")
	private long customerId;

	// @Column(name = "document")
	// private Receipter document;

	public TransactionOut() {
	}

	public TransactionOut(UUID id, Date transactionDate, long value, int discount, long customerId) {
		super(id, transactionDate, value, discount);
		this.customerId = customerId;
	}

}
