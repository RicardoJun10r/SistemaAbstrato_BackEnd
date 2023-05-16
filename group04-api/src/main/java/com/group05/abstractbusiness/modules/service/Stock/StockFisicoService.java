package com.group05.abstractbusiness.modules.service.Stock;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.group05.abstractbusiness.helper.DTO.Business.ProdutoFisicoDTO;
import com.group05.abstractbusiness.modules.model.Business.ProdutoFisico;
import com.group05.abstractbusiness.modules.model.Stock.StockFisico;
import com.group05.abstractbusiness.modules.repository.Stock.StockFisicoRepository;
import com.group05.abstractbusiness.modules.service.Business.ProdutoFisicoService;

@Service
public class StockFisicoService {
    
    @Autowired
    private StockFisicoRepository stockRepository;

    @Autowired
    private ProdutoFisicoService produtoService;

    ModelMapper model = new ModelMapper();
    
    public StockFisico adicionar(StockFisico stockService){
        return stockRepository.save(stockService);
    }

    public StockFisico adicionarProduto(String stockName, String produtoName){
        try {
            StockFisico stock = stockRepository.findByNome(stockName);
            ProdutoFisicoDTO produto = produtoService.findByName(produtoName);
            ProdutoFisico aux = model.map(produto, ProdutoFisico.class);
            
            stock.getProdutosFisicos().add(aux);
            stock.setQuantidade(stock.getQuantidade() + 1);
            aux.setStock(stock);
            return adicionar(stock);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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
