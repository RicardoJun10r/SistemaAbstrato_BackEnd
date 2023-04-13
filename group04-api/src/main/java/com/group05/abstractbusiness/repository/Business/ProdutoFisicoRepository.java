package com.group05.abstractbusiness.repository.Business;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group05.abstractbusiness.model.Business.ProdutoFisico;

public interface ProdutoFisicoRepository extends JpaRepository<ProdutoFisico, UUID> {

}
