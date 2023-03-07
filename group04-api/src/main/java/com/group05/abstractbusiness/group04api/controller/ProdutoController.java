package com.group05.abstractbusiness.group04api.controller;

import com.group05.abstractbusiness.group04api.service.ProdutoService;

import com.group05.abstractbusiness.group04api.model.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
    
    @org.springframework.beans.factory.annotation.Autowired(required=true)
    private ProdutoService service;

    @PostMapping
    public Produto adicionar(@RequestBody Produto produto){
        return service.adicionar(produto);
    }

}
