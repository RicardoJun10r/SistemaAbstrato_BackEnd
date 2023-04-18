package com.group05.abstractbusiness.controller.Transaction;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group05.abstractbusiness.model.Transaction.TransactionIn;
import com.group05.abstractbusiness.service.Transaction.TransactionInService;

@RestController
@RequestMapping("/transactionIn")
@Validated
public class TransactionInController {

	@Autowired
	private TransactionInService transactionInService;

	@GetMapping("/{transactionIn}")
	public ResponseEntity<TransactionIn> create(@PathVariable TransactionIn transactionIn) {
		TransactionIn newTransactionIn = transactionInService.create(transactionIn);
		return ResponseEntity.ok().body(newTransactionIn);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TransactionIn> findById(@PathVariable UUID id) {
		TransactionIn transactionIn = transactionInService.findById(id);
		return ResponseEntity.ok().body(transactionIn);
	}

	@GetMapping("/{transactionIn}")
	public ResponseEntity<TransactionIn> update(@PathVariable TransactionIn transactionIn) {
		TransactionIn newTransactionIn = transactionInService.update(transactionIn);
		return ResponseEntity.ok().body(newTransactionIn);
	}

}
