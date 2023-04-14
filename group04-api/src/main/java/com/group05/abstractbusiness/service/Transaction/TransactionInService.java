package com.group05.abstractbusiness.service.Transaction;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.group05.abstractbusiness.model.Transaction.TransactionIn;
import com.group05.abstractbusiness.repository.Transaction.TransactionInRepository;

@Service
public class TransactionInService {

	@Autowired
	private TransactionInRepository transactionInRepository;

	@Transactional
	public TransactionIn create(TransactionIn transactionIn) {
		return transactionInRepository.save(transactionIn);
	}

	public TransactionIn findById(UUID id) {
		// return transactionInRepository.findById(id);
		Optional<TransactionIn> transactionIn = transactionInRepository.findById(id);
		return transactionIn.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
				"Transacao de entrada nao encontrada pelo id " + id));
	}

	@Transactional
	public TransactionIn update(TransactionIn transactionIn) {
		return transactionInRepository.save(transactionIn);
	}

	public void delete(UUID id) {
		transactionInRepository.deleteById(id);
	}

}
