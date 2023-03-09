package com.group05.abstractbusiness.controller;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.group05.abstractbusiness.model.PhysicalProduct;
import com.group05.abstractbusiness.model.Produto;
import com.group05.abstractbusiness.service.PhysicalProductService;


@RestController
@RequestMapping("/api/produto/fisico")
public class ProdutoController {
    
    @Autowired
    private PhysicalProductService physicalProductService;

    @PostMapping
    public PhysicalProduct add(@RequestBody PhysicalProduct physicalProduct){
        Produto produtoFisico = new PhysicalProduct(physicalProduct);
        return physicalProductService.adicionar((PhysicalProduct) produtoFisico);
    }

    @GetMapping("/{id}")
    public Optional<PhysicalProduct> buscar(@PathVariable UUID id){
        return physicalProductService.buscar(id);
    }
}
