package com.group05.abstractbusiness.modules.service.Stock;

import java.util.UUID;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group05.abstractbusiness.error.Exception.ResourceNotFoundException;
import com.group05.abstractbusiness.helper.DTO.Business.ProductRes;
import com.group05.abstractbusiness.helper.DTO.Stock.StockDTO;
import com.group05.abstractbusiness.helper.DTO.Stock.StockReq;
import com.group05.abstractbusiness.helper.DTO.Stock.StockRes;
import com.group05.abstractbusiness.modules.model.Business.ProdutoDigital;
import com.group05.abstractbusiness.modules.model.Business.factory.ProdutoFactory;
import com.group05.abstractbusiness.modules.model.Stock.StockDigital;
import com.group05.abstractbusiness.modules.repository.Stock.StockDigitalRepository;
import com.group05.abstractbusiness.modules.service.Business.ProdutoDigitalService;

@Service
public class StockDigitalService {
    
    @Autowired
    private StockDigitalRepository stockDigitalRepository;

    @Autowired
    private ProdutoDigitalService produtoDigitalService;

    private ModelMapper mapper = new ModelMapper();

    public StockRes createStock(StockReq stockDTO){
        return mapper.map(stockDigitalRepository.save(mapper.map( stockDTO, StockDigital.class )), StockRes.class);
    }

    public StockRes addProduct(UUID stockId, ProdutoFactory produtoFactory){

        StockDigital stockDigital = findById(stockId);

        produtoFactory.setStockDigital(stockDigital);

        ProductRes productRes = this.produtoDigitalService.createProduct(produtoFactory);

        stockDigital.getProdutosDigitais().add(mapper.map(productRes, ProdutoDigital.class));

        return mapper.map(stockDigitalRepository.save(stockDigital), StockRes.class);
        
    }

    public StockDigital findById(UUID id){
        Optional<StockDigital> sOptional = stockDigitalRepository.findById(id);
        if(sOptional.isPresent()) return sOptional.get();
        throw new ResourceNotFoundException("Stock não encontrado!");
    }

    public List<StockDigital> listar(){
        return stockDigitalRepository.findAll();
    }

    public String deletar(UUID id){
        stockDigitalRepository.deleteById(id);
        return "Produto Fisico: [ " + id + " ] deletado";
    }
    
}
