package com.group05.abstractbusiness.modules.repository.Business;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group05.abstractbusiness.modules.model.Business.ProdutoFisico;

public interface ProdutoFisicoRepository extends JpaRepository<ProdutoFisico, UUID> {
    List<ProdutoFisico> findByNomeContainingIgnoreCase(String nome);
    Optional<ProdutoFisico> findByNome(String nome);
    List<ProdutoFisico> findByPreco(Double preco);
    List<ProdutoFisico> findByStatus(Boolean stataus);
    List<ProdutoFisico> findByCusto(Double custo);
    List<ProdutoFisico> findByBrand(String brand);
    List<ProdutoFisico> findByCategory(String category);
    List<ProdutoFisico> findBySubCategory(String subCategory);
}
