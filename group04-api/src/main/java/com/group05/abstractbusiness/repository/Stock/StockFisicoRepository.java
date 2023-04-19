package com.group05.abstractbusiness.repository.Stock;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group05.abstractbusiness.model.Stock.StockFisico;

public interface StockFisicoRepository extends JpaRepository<StockFisico, UUID> {
    
}
