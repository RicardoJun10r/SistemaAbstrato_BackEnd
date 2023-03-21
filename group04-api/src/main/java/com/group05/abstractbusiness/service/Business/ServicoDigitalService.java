package com.group05.abstractbusiness.service.business;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group05.abstractbusiness.model.Business.ServicoDigital;
import com.group05.abstractbusiness.repository.ServicoDigitalRepository;

@Service
public class ServicoDigitalService {
    
    @Autowired
    private ServicoDigitalRepository servicoDigitalRepository;

    public ServicoDigital adicionar(ServicoDigital produto){
        return servicoDigitalRepository.save(produto);
    }

    public Optional<ServicoDigital> buscar(UUID id){
        return servicoDigitalRepository.findById(id);
    }

    public List<ServicoDigital> listar(){
        return servicoDigitalRepository.findAll();
    }
}
