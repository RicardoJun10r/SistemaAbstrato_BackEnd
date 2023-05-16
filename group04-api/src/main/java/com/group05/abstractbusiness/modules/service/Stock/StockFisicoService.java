package com.group05.abstractbusiness.modules.service.Stock;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.group05.abstractbusiness.modules.model.Stock.StockFisico;
import com.group05.abstractbusiness.modules.repository.Stock.StockFisicoRepository;

@Service
public class StockFisicoService {
    
    @Autowired
    private StockFisicoRepository stockRepository;

    public StockFisico adicionar(StockFisico stockService){
        return stockRepository.save(stockService);
    }

    public StockFisico buscar(UUID id){
        return stockRepository.findById(id).orElseThrow(
            ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "id não retornar resultado"));
    }


    public List<StockFisico> listar(){
        return stockRepository.findAll();
    }

    public String deletar(UUID id){
        stockRepository.deleteById(id);
        return "Produto Fisico: [ " + id + " ] deletado";
    }

}
