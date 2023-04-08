package com.group05.abstractbusiness.model.Transaction;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true)
	private UUID id;

	@Column(name = "transactionDate")
	private Date transactionDate;

	@Column(name = "cart")
	private Cart cart;

	@Column(name = "value")
	private long value;

	@Column(name = "discount")
	private int discount;

	public Transaction() {
	}

	public Transaction(UUID id, Date transactionDate, Cart cart, long value, int discount) {
		this.id = id;
		this.transactionDate = transactionDate;
		this.cart = cart;
		this.value = value;
		this.discount = discount;
	}

}
