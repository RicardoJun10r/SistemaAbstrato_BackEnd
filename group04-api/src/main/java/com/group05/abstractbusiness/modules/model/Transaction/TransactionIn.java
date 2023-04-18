package com.group05.abstractbusiness.model.Transaction;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class TransactionIn extends Transaction {

	// Alterar JOIN TABLE SUPPLIER
	@Column(name = "supplierId")
	private long supplierId;

	// @Column(name = "document")
	// private Receipter document;

	public TransactionIn() {
	}

	public TransactionIn(UUID id, Date transactionDate, long value, int discount, long supplierId) {
		super(id, transactionDate, value, discount);
		this.supplierId = supplierId;
	}

}
