/*package com.group05.abstractbusiness.controller.Transaction;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.group05.abstractbusiness.model.Transaction.Transaction;
import com.group05.abstractbusiness.service.Transaction.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@GetMapping("/{transaction}")
	public ResponseEntity<Transaction> create(@PathVariable Transaction transaction) {
		Transaction newTransaction = transactionService.create(transaction);
		return ResponseEntity.ok().body(newTransaction);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Transaction> findById(@PathVariable UUID id) {
		Transaction transaction = transactionService.findById(id);
		return ResponseEntity.ok().body(transaction);
	}

	@GetMapping("/{transaction}")
	public ResponseEntity<Transaction> update(@PathVariable Transaction transaction) {
		Transaction newTransaction = transactionService.update(transaction);
		return ResponseEntity.ok().body(newTransaction);
	}

}*/
