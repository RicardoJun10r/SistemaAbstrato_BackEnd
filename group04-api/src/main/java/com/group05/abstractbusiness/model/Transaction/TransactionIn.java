package com.group05.abstractbusiness.model.Transaction;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionIn extends Transaction {

	@Column(name = "supplierId")
	private long supplierId;

	@Column(name = "document")
	private Receipter document;

	public TransactionIn(long supplierId, Receipter document) {
		super();
		this.supplierId = supplierId;
		this.document = document;
	}

	void getProduct() {

	}

}
