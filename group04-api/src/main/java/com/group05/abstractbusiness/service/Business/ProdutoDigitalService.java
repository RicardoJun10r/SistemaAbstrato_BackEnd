package com.group05.abstractbusiness.service.Business;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group05.abstractbusiness.model.Business.ProdutoDigital;
import com.group05.abstractbusiness.repository.ProdutoDigitalRepository;

@Service
public class ProdutoDigitalService {
    
    @Autowired
    private ProdutoDigitalRepository produtoDigitalRepository;

    public ProdutoDigital adicionar(ProdutoDigital produto){
        return produtoDigitalRepository.save(produto);
    }

    public Optional<ProdutoDigital> buscar(UUID id){
        return produtoDigitalRepository.findById(id);
    }

    public List<ProdutoDigital> listar(){
        return produtoDigitalRepository.findAll();
    }

}
