package com.group05.abstractbusiness.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group05.abstractbusiness.model.ProdutoIntelectual;

public interface ProdutoIntelectualRepository extends JpaRepository<ProdutoIntelectual, UUID> {
    
}
