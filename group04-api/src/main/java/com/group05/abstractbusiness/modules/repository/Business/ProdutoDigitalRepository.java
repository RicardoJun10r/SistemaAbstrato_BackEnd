package com.group05.abstractbusiness.modules.repository.Business;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group05.abstractbusiness.modules.model.Business.ProdutoDigital;


public interface ProdutoDigitalRepository extends JpaRepository<ProdutoDigital, UUID> {
    
}
