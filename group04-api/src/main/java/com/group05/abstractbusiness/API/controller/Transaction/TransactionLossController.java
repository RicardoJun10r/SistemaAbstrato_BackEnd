package com.group05.abstractbusiness.controller.Transaction;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group05.abstractbusiness.model.Transaction.TransactionLoss;
import com.group05.abstractbusiness.service.Transaction.TransactionLossService;

@RestController
@RequestMapping("/transactionLoss")
@Validated
public class TransactionLossController {

	@Autowired
	private TransactionLossService transactionLossService;

	@GetMapping("/{transactionLoss}")
	public ResponseEntity<TransactionLoss> create(@PathVariable TransactionLoss transactionLoss) {
		TransactionLoss newTransactionLoss = transactionLossService.create(transactionLoss);
		return ResponseEntity.ok().body(newTransactionLoss);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TransactionLoss> findById(@PathVariable UUID id) {
		TransactionLoss transactionLoss = transactionLossService.findById(id);
		return ResponseEntity.ok().body(transactionLoss);
	}

	@GetMapping("/{transactionLoss}")
	public ResponseEntity<TransactionLoss> update(@PathVariable TransactionLoss transactionLoss) {
		TransactionLoss newTransactionLoss = transactionLossService.update(transactionLoss);
		return ResponseEntity.ok().body(newTransactionLoss);
	}

}
