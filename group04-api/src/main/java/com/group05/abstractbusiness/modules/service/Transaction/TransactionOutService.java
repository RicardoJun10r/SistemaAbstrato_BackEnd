package com.group05.abstractbusiness.modules.service.Transaction;

import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.group05.abstractbusiness.helper.DTO.transaction.TransactionOutDTO;
import com.group05.abstractbusiness.helper.DTO.transaction.TransactionOutReturn;
import com.group05.abstractbusiness.modules.model.Cart;
import com.group05.abstractbusiness.modules.model.Transaction.TransactionOut;
import com.group05.abstractbusiness.modules.repository.CartRepository;
import com.group05.abstractbusiness.modules.repository.Transaction.TransactionFisico.TransactionOutFRepository;

@Service
public class TransactionOutService {

	@Autowired
	private TransactionOutFRepository repository;
	
	@Autowired
	private CartRepository cartRepository;

	private ModelMapper mapper = new ModelMapper();

	@Transactional
	public TransactionOutReturn create(UUID idCart, TransactionOutDTO transaction) {
		Optional<Cart> cart = cartRepository.findById(idCart);
		TransactionOut aux = mapper.map(transaction, TransactionOut.class);
		if(cart.isPresent()){
			aux.setCart(cart.get());
		}else{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Carrinho não encontrado");
		}

		return mapper.map(repository.save(aux), TransactionOutReturn.class);
	}
	public TransactionOutReturn findById(UUID id) {
		return mapper.map(this.repository.findById(id).orElseThrow(
		()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction de id [ " + id +" ] não encontrada")), TransactionOutReturn.class);
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
