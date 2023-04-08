package com.group05.abstractbusiness.service.Transaction;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.group05.abstractbusiness.model.Transaction.TransactionLoss;
import com.group05.abstractbusiness.repository.Transaction.TransactionLossRepository;

@Service
public class TransactionLossService {

	@Autowired
	private TransactionLossRepository transactionLossRepository;

	@Transactional
	public TransactionLoss create(TransactionLoss transactionLoss) {
		return transactionLossRepository.save(transactionLoss);
	}

	public TransactionLoss findById(UUID id) {
		// return transactionLossRepository.findById(id);
		Optional<TransactionLoss> transactionLoss = transactionLossRepository.findById(id);
		return transactionLoss.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
				"Transacao de perda nao encontrada pelo id " + id));
	}

	@Transactional
	public TransactionLoss update(TransactionLoss transactionLoss) {
		return transactionLossRepository.save(transactionLoss);
	}

	public void delete(UUID id) {
		transactionLossRepository.deleteById(id);
	}

}
