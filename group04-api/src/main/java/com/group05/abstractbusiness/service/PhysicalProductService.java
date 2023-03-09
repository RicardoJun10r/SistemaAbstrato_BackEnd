package com.group05.abstractbusiness.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group05.abstractbusiness.model.PhysicalProduct;
import com.group05.abstractbusiness.repository.PhysicalProductRepository;

@Service
public class PhysicalProductService {
    
    @Autowired
    private PhysicalProductRepository repository;

    public PhysicalProduct adicionar(PhysicalProduct produto){
        return repository.save(produto);
    }

    public Optional<PhysicalProduct> buscar(UUID id){
        return repository.findById(id);
    }

}
