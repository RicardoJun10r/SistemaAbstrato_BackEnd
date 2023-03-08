package com.group05.abstractbusiness.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group05.abstractbusiness.model.Produto;
import com.group05.abstractbusiness.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository repository;

    public Produto adicionar(Produto produto){
        return repository.save(produto);
    }

}
