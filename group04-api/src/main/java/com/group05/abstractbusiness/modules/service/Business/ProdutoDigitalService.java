package com.group05.abstractbusiness.modules.service.Business;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.group05.abstractbusiness.modules.model.Business.ProdutoDigital;
import com.group05.abstractbusiness.modules.repository.Business.ProdutoDigitalRepository;

@Service
public class ProdutoDigitalService {
    
    @Autowired
    private ProdutoDigitalRepository produtoDigitalRepository;

    public ProdutoDigital adicionar(ProdutoDigital produto){
        return produtoDigitalRepository.save(produto);
    }

    public Optional<ProdutoDigital> buscar(UUID id){
        Optional<ProdutoDigital> optional = produtoDigitalRepository.findById(id);
        if(optional.isPresent()){
            return optional;
        } else {
            return Optional.of(optional.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto digital [ " + id + " ] não econtrado.")));
        }
    }

    public List<ProdutoDigital> listar(){
        List<ProdutoDigital> lista = produtoDigitalRepository.findAll();
        if(lista.isEmpty()){
            throw new RuntimeException("Nenhum produto encontrado!!! "); 
        } else {
            return lista;
        }
    }

    public String deletar(UUID id){
        try {
            produtoDigitalRepository.deleteById(id);
            return "Produto Digital: [ " + id + " ] deletado";
        } catch (Exception e) {
            throw new RuntimeException("Produto de id = [ " + id + " ] não encontrado!!!");
        }
    }

}
