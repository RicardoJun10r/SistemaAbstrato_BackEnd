package com.group05.abstractbusiness.model.Cart;

import java.util.List;
import java.util.UUID;

import com.group05.abstractbusiness.model.Business.Produto;
import com.group05.abstractbusiness.model.Person.Customer;
import com.group05.abstractbusiness.model.Transaction.Transaction;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true)
	private UUID id;

	@Column(name = "products")
	private List<Produto> products;

	@Column(name = "transaction")
	private Transaction transaction;

	@Column(name = "client")
	private Customer client;

	public Cart(UUID id, List<Produto> products, Transaction transaction, Customer client) {
		this.id = id;
		this.products = products;
		this.transaction = transaction;
		this.client = client;
	}

}
