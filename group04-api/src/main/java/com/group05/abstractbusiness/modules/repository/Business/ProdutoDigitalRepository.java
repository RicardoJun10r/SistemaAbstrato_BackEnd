package com.group05.abstractbusiness.modules.repository.Business;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import com.group05.abstractbusiness.error.Exception.ResourceNotFoundException;
import com.group05.abstractbusiness.modules.model.Business.ProdutoDigital;

public interface ProdutoDigitalRepository extends JpaRepository<ProdutoDigital, UUID> {
    List<ProdutoDigital> findByNameContainingIgnoreCase(String name);
    Optional<ProdutoDigital> findByName(String name) throws ResourceNotFoundException;    
    Optional<ProdutoDigital> findByCode(Long code);
    List<ProdutoDigital> findByPrice(Double price) throws ResourceNotFoundException;
    List<ProdutoDigital> findByStatus(Boolean status);
    List<ProdutoDigital> findByCost(Double cost);
    List<ProdutoDigital> findByBrand(String brand);
    List<ProdutoDigital> findByCategory(String category);
    List<ProdutoDigital> findBySubCategory(String subCategory);
}
