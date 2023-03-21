package com.group05.abstractbusiness.service.business;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group05.abstractbusiness.model.Business.ProdutoIntelectual;
import com.group05.abstractbusiness.repository.ProdutoIntelectualRepository;

@Service
public class ProdutoIntelectualService {
    
    @Autowired
    private ProdutoIntelectualRepository produtoIntelectualRepository;

    public ProdutoIntelectual adicionar(ProdutoIntelectual produto){
        return produtoIntelectualRepository.save(produto);
    }

    public Optional<ProdutoIntelectual> buscar(UUID id){
        return produtoIntelectualRepository.findById(id);
    }

    public List<ProdutoIntelectual> listar(){
        return produtoIntelectualRepository.findAll();
    }
}
