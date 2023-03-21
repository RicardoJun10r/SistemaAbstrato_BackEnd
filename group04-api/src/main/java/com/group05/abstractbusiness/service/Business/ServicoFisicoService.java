package com.group05.abstractbusiness.service.business;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group05.abstractbusiness.model.Business.ServicoFisico;
import com.group05.abstractbusiness.repository.ServicoFisicoRepository;

@Service
public class ServicoFisicoService {
    
    @Autowired
    private ServicoFisicoRepository servicoFisicoRepository;
    
    public ServicoFisico adicionar(ServicoFisico produto){
        return servicoFisicoRepository.save(produto);
    }

    public Optional<ServicoFisico> buscar(UUID id){
        return servicoFisicoRepository.findById(id);
    }

    public List<ServicoFisico> listar(){
        return servicoFisicoRepository.findAll();
    }
}
