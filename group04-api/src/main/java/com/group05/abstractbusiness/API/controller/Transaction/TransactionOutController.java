package com.group05.abstractbusiness.controller.Transaction;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group05.abstractbusiness.model.Transaction.TransactionOut;
import com.group05.abstractbusiness.service.Transaction.TransactionOutService;

@RestController
@RequestMapping("/transactionOut")
@Validated
public class TransactionOutController {

	@Autowired
	private TransactionOutService transactionOutService;

	@GetMapping("/{transactionOut}")
	public ResponseEntity<TransactionOut> create(@PathVariable TransactionOut transactionOut) {
		TransactionOut newTransactionOut = transactionOutService.create(transactionOut);
		return ResponseEntity.ok().body(newTransactionOut);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TransactionOut> findById(@PathVariable UUID id) {
		TransactionOut transactionOut = transactionOutService.findById(id);
		return ResponseEntity.ok().body(transactionOut);
	}

	@GetMapping("/{transactionOut}")
	public ResponseEntity<TransactionOut> update(@PathVariable TransactionOut transactionOut) {
		TransactionOut newTransactionOut = transactionOutService.update(transactionOut);
		return ResponseEntity.ok().body(newTransactionOut);
	}

}
