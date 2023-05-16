package com.group05.abstractbusiness.modules.service.Transaction;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.group05.abstractbusiness.helper.DTO.transaction.TransactionOutDTO;
import com.group05.abstractbusiness.helper.DTO.transaction.TransactionOutReturn;
import com.group05.abstractbusiness.helper.mapper.Transaction.TransactionOutMapper;
import com.group05.abstractbusiness.modules.model.Cart;
import com.group05.abstractbusiness.modules.model.Person.CustomerPF;
import com.group05.abstractbusiness.modules.model.Person.User;
import com.group05.abstractbusiness.modules.model.Transaction.TransactionOut;
import com.group05.abstractbusiness.modules.repository.CartRepository;
import com.group05.abstractbusiness.modules.repository.Person.CustomerPFRepository;
import com.group05.abstractbusiness.modules.repository.Person.UserRepository;
import com.group05.abstractbusiness.modules.repository.Transaction.TransactionFisico.TransactionOutFRepository;

@Service
public class TransactionOutService {

	@Autowired
	private TransactionOutFRepository repository;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CartRepository cartRepository;

	@Transactional
	public TransactionOutReturn create(UUID idCart, TransactionOutDTO transaction) {
		Optional<Cart> cart = cartRepository.findById(idCart);
		TransactionOut aux = TransactionOutMapper
		.INSTACE.toTransactionOut(transaction);
		if(cart.isPresent()){
			aux.setCart(cart.get());
		}else{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Carrinho não encontrado");
		}

		return TransactionOutMapper
		.INSTACE.toTransactionReturn(repository.save(aux));
	}
	public TransactionOutReturn findById(UUID id) {
		return TransactionOutMapper.INSTACE.toTransactionReturn(this.repository.findById(id).orElseThrow(
		()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction de id [ " + id +" ] não encontrada")));
	}
	/*
	@Transactional
	public TransactionOut update(TransactionOut transactionOut) {
		return transactionOutRepository.save(transactionOut);
	}
	 */
	public void delete(UUID id) {
		repository.deleteById(id);
	}

}
