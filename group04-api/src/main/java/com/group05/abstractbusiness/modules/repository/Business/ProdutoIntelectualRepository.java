package com.group05.abstractbusiness.modules.repository.Business;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import com.group05.abstractbusiness.modules.model.Business.ProdutoIntelectual;

public interface ProdutoIntelectualRepository extends JpaRepository<ProdutoIntelectual, UUID> {
    List<ProdutoIntelectual> findByNameContainingIgnoreCase(String name);
    Optional<ProdutoIntelectual> findByName(String name);    
    Optional<ProdutoIntelectual> findByCode(Long code);
    List<ProdutoIntelectual> findByPrice(Double price);
    List<ProdutoIntelectual> findByStatus(Boolean status);
    List<ProdutoIntelectual> findByCost(Double cost);
    List<ProdutoIntelectual> findByBrand(String brand);
    List<ProdutoIntelectual> findByCategory(String category);
    List<ProdutoIntelectual> findBySubCategory(String subCategory);
}
