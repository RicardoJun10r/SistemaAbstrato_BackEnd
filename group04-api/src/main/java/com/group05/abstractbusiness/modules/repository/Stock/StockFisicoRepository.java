package com.group05.abstractbusiness.modules.repository.Stock;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group05.abstractbusiness.modules.model.Stock.StockFisico;
import java.util.List;


public interface StockFisicoRepository extends JpaRepository<StockFisico, UUID> {
   StockFisico findByNome(String nome);
   List<StockFisico> findByLocalizacao(String localizacao); 
}
