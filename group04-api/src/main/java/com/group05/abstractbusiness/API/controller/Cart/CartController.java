package com.group05.abstractbusiness.controller.Cart;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group05.abstractbusiness.model.Cart.Cart;
import com.group05.abstractbusiness.service.Cart.CartService;

@RestController
@RequestMapping("/cart")
@Validated
public class CartController {

	@Autowired
	private CartService cartService;

	@GetMapping("/{cart}")
	public ResponseEntity<Cart> create(@PathVariable Cart cart) {
		Cart newCart = cartService.create(cart);
		return ResponseEntity.ok().body(newCart);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cart> findById(@PathVariable UUID id) {
		Cart cart = cartService.findById(id);
		return ResponseEntity.ok().body(cart);
	}

	@GetMapping("/{cart}")
	public ResponseEntity<Cart> update(@PathVariable Cart cart) {
		Cart newCart = cartService.update(cart);
		return ResponseEntity.ok().body(newCart);
	}

}
