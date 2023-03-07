package com.group05.abstractbusiness.group04api.service;

import org.springframework.stereotype.Service;


import com.group05.abstractbusiness.group04api.model.Produto;
import com.group05.abstractbusiness.group04api.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @org.springframework.beans.factory.annotation.Autowired(required=true)
    private ProdutoRepository repository;

    public Produto adicionar(Produto produto){
        repository.save(produto);
        return produto;
    }

}
