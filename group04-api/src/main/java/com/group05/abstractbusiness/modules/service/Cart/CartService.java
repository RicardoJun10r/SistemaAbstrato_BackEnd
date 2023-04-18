package com.group05.abstractbusiness.service.Cart;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.group05.abstractbusiness.model.Cart.Cart;
import com.group05.abstractbusiness.repository.Cart.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;

	@Transactional
	public Cart create(Cart cart) {
		return cartRepository.save(cart);
	}

	public Cart findById(UUID id) {
		// return cartRepository.findById(id);
		Optional<Cart> cart = cartRepository.findById(id);
		return cart.orElseThrow(
				() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Carrinho nao encontrado pelo id " + id));
	}

	@Transactional
	public Cart update(Cart cart) {
		return cartRepository.save(cart);
	}

	public void delete(UUID id) {
		cartRepository.deleteById(id);
	}

}
