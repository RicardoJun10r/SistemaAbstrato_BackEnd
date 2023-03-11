package com.group05.abstractbusiness.controller;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.group05.abstractbusiness.factory.AbstractFactoryProdutoServico;
import com.group05.abstractbusiness.model.ProdutoDigital;
import com.group05.abstractbusiness.model.ProdutoFisico;
import com.group05.abstractbusiness.model.Produto;
import com.group05.abstractbusiness.service.ProdutoDigitalService;
import com.group05.abstractbusiness.service.ProdutoFisicoService;


/**
 *  AJEITAR
 *  REFATORAR TODO ESSE CONTROLLER PARA IMPLEMENTAR O PADRÃO DE PROJETO ABSTRACT FACTORY
 */
@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
    
    @Autowired
    private ProdutoFisicoService physicalProductService;

    @Autowired
    private ProdutoDigitalService digitalProductService;

    private AbstractFactoryProdutoServico fabrica;

    @PostMapping("/fisico")
    public ProdutoFisico addFisico(@RequestBody ProdutoFisico physicalProduct){
        Produto produtoFisico = new ProdutoFisico(physicalProduct);
        return physicalProductService.adicionar((ProdutoFisico) produtoFisico);
    }

    @GetMapping("/fisico/search/{id}")
    public Optional<ProdutoFisico> buscarFisico(@PathVariable UUID id){
        return physicalProductService.buscar(id);
    }

    @GetMapping("/fisico/listar")
    public List<ProdutoFisico> listarFisico(){
        List<ProdutoFisico> lista = physicalProductService.listar();
        return lista;
    }

    @PostMapping("/digital")
    public ProdutoDigital addDigital(@RequestBody ProdutoDigital digitalProduct){
        Produto produto = new ProdutoDigital(digitalProduct);
        return digitalProductService.adicionar((ProdutoDigital) produto);
    }

    @GetMapping("/digital/search/{id}")
    public Optional<ProdutoDigital> buscarDigital(@PathVariable UUID id){
        return digitalProductService.buscar(id);
    }

    @GetMapping("/digital/listar")
    public List<ProdutoDigital> listarDigital(){
        List<ProdutoDigital> lista = digitalProductService.listar();
        return lista;
    }

}
