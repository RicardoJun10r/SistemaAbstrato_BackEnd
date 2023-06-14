package com.group05.abstractbusiness.modules.repository.Business;


import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import com.group05.abstractbusiness.modules.model.Business.ProdutoFisico;

public interface ProdutoFisicoRepository extends JpaRepository<ProdutoFisico, UUID> {
    List<ProdutoFisico> findByNameContainingIgnoreCase(String name);
    Optional<ProdutoFisico> findByName(String name);    
    Optional<ProdutoFisico> findByCode(Long code);
    List<ProdutoFisico> findByPrice(Double price);
    List<ProdutoFisico> findByStatus(Boolean status);
    List<ProdutoFisico> findByCost(Double cost);
    List<ProdutoFisico> findByBrand(String brand);
    List<ProdutoFisico> findByCategory(String category);
    List<ProdutoFisico> findBySubCategory(String subCategory);
}
