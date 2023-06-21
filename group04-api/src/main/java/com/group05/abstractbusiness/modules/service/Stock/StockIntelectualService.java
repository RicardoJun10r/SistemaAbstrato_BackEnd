package com.group05.abstractbusiness.modules.service.Stock;

import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group05.abstractbusiness.error.Exception.ResourceNotFoundException;
import com.group05.abstractbusiness.helper.DTO.Business.ProductIntRes;
import com.group05.abstractbusiness.helper.DTO.Business.ProductReq;
import com.group05.abstractbusiness.helper.DTO.Business.ProductRes;
import com.group05.abstractbusiness.helper.DTO.Stock.StockIntRes;
import com.group05.abstractbusiness.helper.DTO.Stock.StockReq;
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

    public StockRes createStock(StockReq stockReq){
        return mapper.map(stockIntelectualRepository.save(mapper.map( stockReq, StockIntelectual.class )), StockIntRes.class);
    }

    public ProductRes addProduct(UUID stockId, ProductReq productReq){

        StockIntelectual stockIntelectual = findById(stockId);

        productReq.setStockIntelectual(stockIntelectual);

        ProductRes productRes = this.produtoIntelectualService.createProduct(productReq);

        stockIntelectual.getProdutoIntelectuais().add(mapper.map(productRes, ProdutoIntelectual.class));

        stockIntelectualRepository.save(stockIntelectual);

        return mapper.map(productRes, ProductIntRes.class);
        
    }

    public StockIntelectual findById(UUID id){
        Optional<StockIntelectual> sOptional = stockIntelectualRepository.findById(id);
        if(sOptional.isPresent()) return sOptional.get();
        throw new ResourceNotFoundException("Stock não encontrado!");
    }

}
