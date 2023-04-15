package com.group05.abstractbusiness.service.Stock;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group05.abstractbusiness.model.Stock.StockFisico;
import com.group05.abstractbusiness.repository.Stock.StockFisicoRepository;

@Service
public class StockFisicoService {
    
    @Autowired
    private StockFisicoRepository stockRepository;

    public StockFisico adicionar(StockFisico stockService){
        return stockRepository.save(stockService);
    }

    public Optional<StockFisico> buscar(UUID id){
        return stockRepository.findById(id);
    }

    public List<StockFisico> listar(){
        return stockRepository.findAll();
    }

    public String deletar(UUID id){
        stockRepository.deleteById(id);
        return "Produto Fisico: [ " + id + " ] deletado";
    }

}
