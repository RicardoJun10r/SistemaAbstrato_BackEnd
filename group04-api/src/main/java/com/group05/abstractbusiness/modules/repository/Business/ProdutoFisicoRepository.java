package com.group05.abstractbusiness.modules.repository.Business;


import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group05.abstractbusiness.modules.model.Business.ProdutoFisico;

public interface ProdutoFisicoRepository extends JpaRepository<ProdutoFisico, UUID> {
    List<ProdutoFisico> findByNomeContainingIgnoreCase(String nome);


}
