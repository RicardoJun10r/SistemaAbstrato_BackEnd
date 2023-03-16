package com.group05.abstractbusiness.service.Business;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group05.abstractbusiness.model.Business.ServicoIntelectual;
import com.group05.abstractbusiness.repository.ServicoIntelectualRepository;

@Service
public class ServicoIntelectualService {
    
    @Autowired
    private ServicoIntelectualRepository servicoIntelectualRepository;

    public ServicoIntelectual adicionar(ServicoIntelectual produto){
        return servicoIntelectualRepository.save(produto);
    }

    public Optional<ServicoIntelectual> buscar(UUID id){
        return servicoIntelectualRepository.findById(id);
    }

    public List<ServicoIntelectual> listar(){
        return servicoIntelectualRepository.findAll();
    }
}
