package com.group05.abstractbusiness.model.Transaction;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.group05.abstractbusiness.model.Business.Produto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class TransactionLoss extends Transaction {

	@Column(name = "products")
	List<Produto> products;

	public TransactionLoss() {
	}

	public TransactionLoss(UUID id, Date transactionDate, long value, int discount, List<Produto> products) {
		super(id, transactionDate, value, discount);
		this.products = products;
	}

}
