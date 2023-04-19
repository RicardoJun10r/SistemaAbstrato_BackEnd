package com.group05.abstractbusiness.modules.service.Stock;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group05.abstractbusiness.modules.model.Stock.StockIntelectual;
import com.group05.abstractbusiness.modules.repository.Stock.StockIntelectualRepository;

@Service
public class StockIntelectualService {
    
    @Autowired
    private StockIntelectualRepository stockIntelectualRepository;

    public StockIntelectual adicionar(StockIntelectual stockService){
        return stockIntelectualRepository.save(stockService);
    }

    public Optional<StockIntelectual> buscar(UUID id){
        return stockIntelectualRepository.findById(id);
    }

    public List<StockIntelectual> listar(){
        return stockIntelectualRepository.findAll();
    }

    public String deletar(UUID id){
        stockIntelectualRepository.deleteById(id);
        return "Produto Fisico: [ " + id + " ] deletado";
    }

}
