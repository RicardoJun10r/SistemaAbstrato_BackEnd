package com.group05.abstractbusiness.modules.service.Stock;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group05.abstractbusiness.modules.model.Stock.StockDigital;
import com.group05.abstractbusiness.modules.repository.Stock.StockDigitalRepository;

@Service
public class StockDigitalService {
    
    @Autowired
    private StockDigitalRepository stockDigitalRepository;

    public StockDigital adicionar(StockDigital stockService){
        return stockDigitalRepository.save(stockService);
    }

    public Optional<StockDigital> buscar(UUID id){
        return stockDigitalRepository.findById(id);
    }

    public List<StockDigital> listar(){
        return stockDigitalRepository.findAll();
    }

    public String deletar(UUID id){
        stockDigitalRepository.deleteById(id);
        return "Produto Fisico: [ " + id + " ] deletado";
    }
    
}
