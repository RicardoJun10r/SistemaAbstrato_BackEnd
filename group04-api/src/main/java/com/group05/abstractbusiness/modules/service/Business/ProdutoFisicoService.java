package com.group05.abstractbusiness.modules.service.Business;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.group05.abstractbusiness.helper.DTO.Business.ProdutoFisicoDTO;
import com.group05.abstractbusiness.modules.model.Business.ProdutoFisico;
import com.group05.abstractbusiness.modules.repository.Business.ProdutoFisicoRepository;

@Service
public class ProdutoFisicoService {
    
    @Autowired
    private ProdutoFisicoRepository produtoFisicoRepository;

    public ProdutoFisico create(ProdutoFisico produto){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(produtoFisicoRepository.save(produto), ProdutoFisico.class);
    }

    public ProdutoFisicoDTO findById(UUID id){
        ModelMapper mapper = new ModelMapper();
        try {
            if(produtoFisicoRepository.findById(id).isPresent()){
            ProdutoFisicoDTO dto = mapper.map(produtoFisicoRepository.findById(id).get(), ProdutoFisicoDTO.class);
            return dto;
            } else{
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto fisico com id [" + id + " ] não encontrado");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ProdutoFisico> listar(){
        ModelMapper mapper = new ModelMapper();
        return produtoFisicoRepository.findAll();
    }

    public String deletar(UUID id){
        produtoFisicoRepository.deleteById(id);
        return "Produto Fisico: [ " + id + " ] deletado";
    }

}
