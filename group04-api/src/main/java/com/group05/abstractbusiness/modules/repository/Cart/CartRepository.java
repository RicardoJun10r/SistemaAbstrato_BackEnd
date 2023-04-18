package com.group05.abstractbusiness.repository.Cart;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group05.abstractbusiness.model.Cart.Cart;

public interface CartRepository extends JpaRepository<Cart, UUID> {

}
