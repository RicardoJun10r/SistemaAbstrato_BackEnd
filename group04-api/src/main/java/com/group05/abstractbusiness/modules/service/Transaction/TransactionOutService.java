/*package com.group05.abstractbusiness.service.Transaction;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.group05.abstractbusiness.model.Transaction.TransactionOut;
import com.group05.abstractbusiness.repository.Transaction.TransactionOutRepository;

@Service
public class TransactionOutService {

	@Autowired
	private TransactionOutRepository transactionOutRepository;

	@Transactional
	public TransactionOut create(TransactionOut transactionOut) {
		return transactionOutRepository.save(transactionOut);
	}

	public TransactionOut findById(UUID id) {
		// return transactionOutRepository.findById(id);
		Optional<TransactionOut> transactionOut = transactionOutRepository.findById(id);
		return transactionOut.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
				"Transacao de saida nao encontrada pelo id " + id));
	}

	@Transactional
	public TransactionOut update(TransactionOut transactionOut) {
		return transactionOutRepository.save(transactionOut);
	}

	public void delete(UUID id) {
		transactionOutRepository.deleteById(id);
	}

}*/
