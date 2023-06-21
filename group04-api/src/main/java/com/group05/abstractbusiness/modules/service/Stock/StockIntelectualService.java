package com.group05.abstractbusiness.modules.service.Stock;

import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group05.abstractbusiness.error.Exception.ResourceNotFoundException;
import com.group05.abstractbusiness.helper.DTO.Business.ProductRes;
import com.group05.abstractbusiness.helper.DTO.Stock.StockDTO;
import com.group05.abstractbusiness.helper.DTO.Stock.StockRes;
import com.group05.abstractbusiness.modules.model.Business.ProdutoIntelectual;
import com.group05.abstractbusiness.modules.model.Business.factory.ProdutoFactory;
import com.group05.abstractbusiness.modules.model.Stock.StockIntelectual;
import com.group05.abstractbusiness.modules.repository.Stock.StockIntelectualRepository;
import com.group05.abstractbusiness.modules.service.Business.ProdutoIntelectualService;

@Service
public class StockIntelectualService {
    
    @Autowired
    private StockIntelectualRepository stockIntelectualRepository;

    @Autowired
    private ProdutoIntelectualService produtoIntelectualService;

    private ModelMapper mapper = new ModelMapper();

    public StockRes createStock(StockDTO stockDTO){
        return mapper.map(stockIntelectualRepository.save(mapper.map( stockDTO, StockIntelectual.class )), StockRes.class);
    }

    public StockRes addProduct(UUID stockId, ProdutoFactory produtoFactory){

        StockIntelectual stockIntelectual = findById(stockId);

        produtoFactory.setStockIntelectual(stockIntelectual);

        ProductRes productRes = this.produtoIntelectualService.createProduct(produtoFactory);

        stockIntelectual.getProdutoIntelectuais().add(mapper.map(productRes, ProdutoIntelectual.class));

        return mapper.map(stockIntelectualRepository.save(stockIntelectual), StockRes.class);
        
    }

    public StockIntelectual findById(UUID id){
        Optional<StockIntelectual> sOptional = stockIntelectualRepository.findById(id);
        if(sOptional.isPresent()) return sOptional.get();
        throw new ResourceNotFoundException("Stock não encontrado!");
    }

}
