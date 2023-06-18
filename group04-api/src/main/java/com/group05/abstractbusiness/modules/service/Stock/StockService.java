// package com.group05.abstractbusiness.modules.service.Stock;

// import java.util.List;
// import java.util.UUID;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.group05.abstractbusiness.error.Exception.ResourceBadRequest;
// import com.group05.abstractbusiness.helper.DTO.Stock.StockRes;
// import com.group05.abstractbusiness.modules.model.Business.factory.ProdutoFactory;
// import com.group05.abstractbusiness.utils.Enums.TipoProduto;

// import jakarta.transaction.Transactional;

// @Service
// public class StockService {
    
//     @Autowired
//     private StockFisicoService stockFisicoService;

//     @Autowired
//     private StockDigitalService stockDigitalService;

//     @Autowired
//     private StockIntelectualService stockIntelectualService;

//     @Transactional
//     public StockRes createStock(TipoProduto tipoProduto, StockRes stockRes){

//         switch (tipoProduto) {
//             case FISICO:
//                 return stockFisicoService.createStock(stockRes);

//             case DIGITAL:
//                 return stockDigitalService.createStock(stockRes);

//             case INTELECTUAL:
//                 return stockIntelectualService.createStock(stockRes);
        
//             default:
//                 throw new ResourceBadRequest("Cheque o tipo do produto");
//         }

//     }

//     public StockRes addProduct(TipoProduto tipoProduto, UUID stockName, ProdutoFactory produtoFactory, String email){
        
//         switch (tipoProduto) {
//             case FISICO:
//                 return stockFisicoService.addProduct(stockName, produtoFactory, email);

//             case DIGITAL:
//                 return stockDigitalService.addProduct(stockName, produtoFactory);

//             case INTELECTUAL:
//                 return stockIntelectualService.addProduct(stockName, produtoFactory);
        
//             default:
//                 throw new ResourceBadRequest("Cheque o tipo do produto");
//         }

//     }

//     public List<StockRes> findAllProducts(TipoProduto tipoProduto){
        
//         switch (tipoProduto) {
//             case FISICO:
//                 return stockFisicoService.findAllProducts();

//             case DIGITAL:
//                 return stockDigitalService.findAllProducts();

//             case INTELECTUAL:
//                 return stockIntelectualService.findAllProducts();
        
//             default:
//                 throw new ResourceBadRequest("Cheque o tipo do produto");
//         }

//     }

//     public StockProducts findById(UUID stockId){
//         return stockRepository.findById(stockId).get();
//     }

// }
