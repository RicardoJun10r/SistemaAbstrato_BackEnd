package com.group05.abstractbusiness.modules.repository.Business;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group05.abstractbusiness.modules.model.Business.ProdutoIntelectual;

public interface ProdutoIntelectualRepository extends JpaRepository<ProdutoIntelectual, UUID> {
    
}
