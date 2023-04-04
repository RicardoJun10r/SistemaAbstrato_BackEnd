package com.group05.abstractbusiness.service.Business;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group05.abstractbusiness.model.Business.ProdutoFisico;
import com.group05.abstractbusiness.repository.ProdutoFisicoRepository;

@Service
public class ProdutoFisicoService {
    
    @Autowired
    private ProdutoFisicoRepository produtoFisicoRepository;

    public ProdutoFisico adicionar(ProdutoFisico produto){
        return produtoFisicoRepository.save(produto);
    }

    public Optional<ProdutoFisico> buscar(UUID id){
        return produtoFisicoRepository.findById(id);
    }

    public List<ProdutoFisico> listar(){
        return produtoFisicoRepository.findAll();
    }

    public String deletar(UUID id){
        produtoFisicoRepository.deleteById(id);
        return "Produto Fisico: [ " + id + " ] deletado";
    }

}
