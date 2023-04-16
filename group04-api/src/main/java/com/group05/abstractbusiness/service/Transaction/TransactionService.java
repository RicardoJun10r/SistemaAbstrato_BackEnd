/*package com.group05.abstractbusiness.service.Transaction;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.group05.abstractbusiness.model.Transaction.Transaction;
import com.group05.abstractbusiness.repository.Transaction.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Transactional
	public Transaction create(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	public Transaction findById(UUID id) {
		// return transactionRepository.findById(id);
		Optional<Transaction> transaction = transactionRepository.findById(id);
		return transaction.orElseThrow(
				() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Transacao nao encontrada pelo id " + id));
	}

	@Transactional
	public Transaction update(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	public void delete(UUID id) {
		transactionRepository.deleteById(id);
	}

}*/
