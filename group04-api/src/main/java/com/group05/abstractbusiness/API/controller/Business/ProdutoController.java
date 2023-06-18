// package com.group05.abstractbusiness.API.controller.Business;

// import java.util.UUID;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import com.group05.abstractbusiness.helper.DTO.Business.ProductRes;
// import com.group05.abstractbusiness.modules.model.Business.factory.*;
// import com.group05.abstractbusiness.modules.service.Business.*;
// import com.group05.abstractbusiness.utils.Enums.TipoProduto;

// @RestController
// @RequestMapping("/produto")
// public class ProdutoController {
    
//     @Autowired
//     private ProdutoService produtosService;

//     @PostMapping("/{tipo}")
//     public ResponseEntity<ProductRes> criarProduto(@PathVariable TipoProduto tipo, @RequestParam String email, @RequestBody ProdutoFactory produtoFactory){
//         return new ResponseEntity<ProductRes>(this.produtosService.createProduct(tipo, produtoFactory, email), HttpStatus.CREATED);
//     }

//     @GetMapping("/{tipo}")
//     public ResponseEntity<List<ProductRes>> findAll(@PathVariable TipoProduto tipo){
//         return new ResponseEntity<List<ProductRes>>(this.produtosService.findAll(tipo), HttpStatus.OK);
//     }

//     @PutMapping("/{tipo}/{id}")
//     public ResponseEntity<ProductRes> update(@PathVariable TipoProduto tipo, @PathVariable UUID id, @RequestBody ProdutoFactory produtoFactory){
//         return new ResponseEntity<ProductRes>(this.produtosService.updateProdutos(tipo, id, produtoFactory), HttpStatus.OK);
//     }

//     @DeleteMapping("/{tipo}/{id}")
//     public ResponseEntity<String> delete(@PathVariable TipoProduto tipo, @PathVariable UUID id){
//         return new ResponseEntity<String>(this.produtosService.deletar(tipo, id), HttpStatus.OK);
//     }

// }
