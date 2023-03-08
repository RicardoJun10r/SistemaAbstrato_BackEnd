package com.group05.abstractbusiness.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.group05.abstractbusiness.model.Produto;
import com.group05.abstractbusiness.service.ProdutoService;


@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
    
    @Autowired
    private ProdutoService productService;

    @GetMapping("/executar")
    public String ola(){
        return "Ola";
    }

    @PostMapping
    public ResponseEntity<Produto> adicionar(@RequestBody Produto produto){
        this.productService.adicionar(produto);
        URI uri  = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produto.getID()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
