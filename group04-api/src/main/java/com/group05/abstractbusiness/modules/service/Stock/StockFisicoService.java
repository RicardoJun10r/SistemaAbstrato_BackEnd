package com.group05.abstractbusiness.modules.service.Stock;

import java.util.UUID;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group05.abstractbusiness.error.Exception.ResourceNotFoundException;
import com.group05.abstractbusiness.helper.DTO.Business.ProductPhyRes;
import com.group05.abstractbusiness.helper.DTO.Business.ProductReq;
import com.group05.abstractbusiness.helper.DTO.Business.ProductRes;
import com.group05.abstractbusiness.helper.DTO.Stock.StockPhyRes;
import com.group05.abstractbusiness.helper.DTO.Stock.StockReq;
import com.group05.abstractbusiness.helper.DTO.Stock.StockRes;
import com.group05.abstractbusiness.modules.model.Business.ProdutoFisico;
import com.group05.abstractbusiness.modules.model.Business.factory.ProdutoFactory;
import com.group05.abstractbusiness.modules.model.Stock.StockFisico;
import com.group05.abstractbusiness.modules.repository.Stock.StockFisicoRepository;
import com.group05.abstractbusiness.modules.service.Business.ProdutoFisicoService;

@Service
public class StockFisicoService {
    
    @Autowired
    private StockFisicoRepository stockFisicoRepository;

    @Autowired
    private ProdutoFisicoService produtoFisicoService;

    private ModelMapper mapper = new ModelMapper();
    
    public StockRes createStock(StockReq stockReq){
        return mapper.map(stockFisicoRepository.save(mapper.map( stockReq, StockFisico.class )), StockPhyRes.class);
    }

    public ProductRes addProduct(UUID stockId, ProductReq productReq, String supplier){

        StockFisico stockFisico = findById(stockId);

        productReq.setStockFisico(stockFisico);

        ProductRes productRes = this.produtoFisicoService.createProduct(productReq, supplier);

        stockFisico.getProdutosFisicos().add(mapper.map(productRes, ProdutoFisico.class));

        stockFisicoRepository.save(stockFisico);

        return mapper.map(productRes, ProductPhyRes.class);

    }

    public StockFisico findById(UUID id){

        Optional<StockFisico> sOptional = stockFisicoRepository.findById(id);

        if(sOptional.isPresent()) return sOptional.get();

        throw new ResourceNotFoundException("Stock não encontrado!");

    }


    public List<StockFisico> findAll(){
        return stockFisicoRepository.findAll();
    }

    public String delete(UUID id){
        stockFisicoRepository.deleteById(id);
        return "Produto Fisico: [ " + id + " ] deletado";
    }

}
