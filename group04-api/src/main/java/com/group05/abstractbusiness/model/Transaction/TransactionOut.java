package com.group05.abstractbusiness.model.Transaction;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionOut extends Transaction {

	@Column(name = "customerId")
	private long customerId;

	@Column(name = "document")
	private Receipter document;

	public TransactionOut(long customerId, Receipter document) {
		super();
		this.customerId = customerId;
		this.document = document;
	}

	void sellProduct() {

	}

}
