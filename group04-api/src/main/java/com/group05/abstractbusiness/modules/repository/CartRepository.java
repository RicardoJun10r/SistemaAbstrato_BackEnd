package com.group05.abstractbusiness.modules.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group05.abstractbusiness.modules.model.Cart;

public interface CartRepository extends JpaRepository<Cart, UUID> {
    
}
