package com.group05.abstractbusiness.modules.service.Transaction;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.group05.abstractbusiness.helper.DTO.person.transaction.TransactionInDTO;
import com.group05.abstractbusiness.helper.DTO.person.transaction.TransactionInReturn;
import com.group05.abstractbusiness.helper.mapper.Transaction.TransactionInMapper;
import com.group05.abstractbusiness.modules.model.Transaction.TransactionIn;
import com.group05.abstractbusiness.modules.repository.Transaction.TransactionFisico.TransactionInFRepository;

@Service
public class TransactionInService {

	@Autowired
	private TransactionInFRepository repository;

	@Transactional
	public TransactionInReturn create(TransactionInDTO transaction) {
		return TransactionInMapper
		.INSTACE.toTransactionReturn(repository.save(TransactionInMapper
		.INSTACE.toTransactionIn(transaction)));
	}

	public TransactionInReturn findById(UUID id) {
		return TransactionInMapper.INSTACE.toTransactionReturn(this.repository.findById(id).orElseThrow(
		()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction de id [ " + id +" ] não encontrada")));
	}

	/*@Transactional
	public TransactionInReturn update(TransactionInReturn transaction) {
		TransactionInReturn transactionFind = findById(transaction.getId());
		transactionFind.setCart(transaction.getCart());
		transactionFind.setDiscount(transaction.getDiscount());
		transactionFind.setValue(transaction.getValue());
		return TransactionInMapper.INSTACE.toTransactionReturn(this.repository
		.save(TransactionInMapper.INSTACE.toTransactionIn(transactionFind)));
	}*/

	public void delete(UUID id) {
		repository.deleteById(id);
	}

}
