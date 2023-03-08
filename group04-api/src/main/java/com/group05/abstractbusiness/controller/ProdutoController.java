package com.group05.abstractbusiness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group05.abstractbusiness.model.Produto;
import com.group05.abstractbusiness.service.ProdutoService;


@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
    
    @Autowired
    private ProdutoService service;

    @GetMapping("/executar")
    public String ola(){
        return "Ola";
    }

    @PostMapping
    public Produto adicionar(@RequestBody Produto produto){
        return service.adicionar(produto);
    }

}
