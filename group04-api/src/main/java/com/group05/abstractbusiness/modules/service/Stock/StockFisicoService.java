// package com.group05.abstractbusiness.modules.service.Stock;

// import java.util.UUID;
// import java.util.List;

// import org.modelmapper.ModelMapper;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.stereotype.Service;
// import org.springframework.web.server.ResponseStatusException;

// import com.group05.abstractbusiness.helper.DTO.Business.ProductRes;
// import com.group05.abstractbusiness.helper.DTO.Stock.StockRes;
// import com.group05.abstractbusiness.modules.model.Business.ProdutoFisico;
// import com.group05.abstractbusiness.modules.model.Business.factory.ProdutoFactory;
// import com.group05.abstractbusiness.modules.model.Stock.StockFisico;
// import com.group05.abstractbusiness.modules.repository.Stock.StockFisicoRepository;
// import com.group05.abstractbusiness.modules.service.Business.ProdutoFisicoService;

// @Service
// public class StockFisicoService {
    
//     @Autowired
//     private StockFisicoRepository stockFisicoRepository;

//     @Autowired
//     private ProdutoFisicoService produtoFisicoService;

//     private ModelMapper mapper = new ModelMapper();
    
//     public StockRes createStock(StockRes stockService){
//         return mapper.map(stockFisicoRepository.save(mapper.map( stockService, StockFisico.class )), StockRes.class);
//     }

//     public StockRes addProduct(UUID stockId, ProdutoFactory produtoFactory, String email){

//         StockFisico stockFisico = findById(stockId);

//         produtoFactory.setStockFisico(stockFisico);

//         ProductRes productRes = this.produtoFisicoService.createProduct(produtoFactory, email);

//         stockFisico.getProdutosFisicos().add(mapper.map(productRes, ProdutoFisico.class));

//         return mapper.map(stockFisicoRepository.save(stockFisico), StockRes.class);

//     }

//     public StockFisico findById(UUID id){
//         return stockFisicoRepository.findById(id).orElseThrow(
//             ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "id não retornar resultado"));
//     }


//     public List<StockFisico> findAll(){
//         return stockFisicoRepository.findAll();
//     }

//     public String delete(UUID id){
//         stockFisicoRepository.deleteById(id);
//         return "Produto Fisico: [ " + id + " ] deletado";
//     }

// }
