package com.group05.abstractbusiness.modules.repository.Stock;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group05.abstractbusiness.modules.model.Stock.StockIntelectual;

public interface StockIntelectualRepository extends JpaRepository<StockIntelectual, UUID> {
    
}
