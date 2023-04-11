package com.group05.abstractbusiness.controller.Business;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group05.abstractbusiness.model.Business.factory.*;
import com.group05.abstractbusiness.model.Business.*;
import com.group05.abstractbusiness.model.Business.DTO.ProdutoDTO;
import com.group05.abstractbusiness.service.Business.*;


/**
 *  ----------- AJEITAR ----------- 
 *  REFATORAR ESSE CONTROLLER PARA IMPLEMENTAR O PADRÃO DE PROJETO ABSTRACT FACTORY
 */
@RestController
@RequestMapping("/api")
public class ProdutoController {
    
    @Autowired
    private ProdutoFisicoService produtoFisicoService;

    @Autowired
    private ProdutoDigitalService produtoDigitalService;

    @Autowired
    private ProdutoIntelectualService produtoIntelectualService;

    //#region CRIAR PRODUTOS OU SERVIÇOS

    @PostMapping("/produto/{tipo}")
    public ResponseEntity<Produto> criarFisico(@PathVariable String tipo, @RequestBody ProdutoFactory produtoFactory){
        ModelMapper mapper = new ModelMapper();
        if(tipo.equals("fisico")){
            return new ResponseEntity<Produto>(produtoFisicoService.adicionar(mapper.map(produtoFactory.criarFisco(), ProdutoFisico.class)), HttpStatus.CREATED);
        } else if(tipo.equals("digital")){
            return new ResponseEntity<Produto>(produtoDigitalService.adicionar(mapper.map(produtoFactory.criarDigital(), ProdutoDigital.class)), HttpStatus.CREATED);
        } else if(tipo.equals("intelectual")){
            return new ResponseEntity<Produto>(produtoIntelectualService.adicionar(mapper.map(produtoFactory.criarIntelectual(), ProdutoIntelectual.class)), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    //#endregion

    @GetMapping("/produto/fisico/{uuid}")
    public ResponseEntity<Optional<ProdutoFisico>> getFisicoById(@PathVariable UUID uuid){
        try {
            return new ResponseEntity<>(produtoFisicoService.buscar(uuid), HttpStatus.OK); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/produto/digital/{uuid}")
    public ResponseEntity<Optional<ProdutoDigital>> getDigitalById(@PathVariable UUID uuid){
        try {
            return new ResponseEntity<>(produtoDigitalService.buscar(uuid), HttpStatus.OK); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/produto/intelectual/{uuid}")
    public ResponseEntity<Optional<ProdutoIntelectual>> getIntelectualById(@PathVariable UUID uuid){
        try {
            return new ResponseEntity<>(produtoIntelectualService.buscar(uuid), HttpStatus.OK); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    // EM ANÁLISE
    // @GetMapping("/produto/{tipo}/{uuid}")
    // public ResponseEntity<Optional<ProdutoDTO>> getProduto(@PathVariable String tipo, @PathVariable UUID uuid){
    //     ModelMapper mapper = new ModelMapper();
    //     if(tipo.equals("fisico")){
    //         Optional<ProdutoFisico> produtoFisico = produtoFisicoService.buscar(uuid);
    //         ProdutoDTO optional = mapper.map(produtoFisico, ProdutoDTO.class);
    //         return new ResponseEntity<Optional<ProdutoDTO>>(Optional.of(optional) , HttpStatus.OK);
    //     } else if(tipo.equals("digital")){
    //         Optional<ProdutoDigital> produtoDigital = produtoDigitalService.buscar(uuid);
    //         ProdutoDTO optional = mapper.map(produtoDigital, ProdutoDTO.class);
    //         return new ResponseEntity<Optional<ProdutoDTO>>(Optional.of(optional) , HttpStatus.OK);
    //     } else if(tipo.equals("intelectual")){
    //         Optional<ProdutoIntelectual> produtoIntelectual = produtoIntelectualService.buscar(uuid);
    //         ProdutoDTO optional = mapper.map(produtoIntelectual, ProdutoDTO.class);
    //         return new ResponseEntity<Optional<ProdutoDTO>>(Optional.of(optional) , HttpStatus.OK);
    //     }
    //     return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    // }

    @GetMapping("/produto/fisico")
    public List<ProdutoFisico> listarFisico(){
        try {
            return produtoFisicoService.listar(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/produto/digital")
    public List<ProdutoDigital> listarDigitalById(){
        try {
            return produtoDigitalService.listar(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/produto/intelectual")
    public List<ProdutoIntelectual> listarIntelectualById(){
        try {
            return produtoIntelectualService.listar(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("/produto/{tipo}/{uuid}")
    public String deleteProduto(@PathVariable String tipo, @PathVariable UUID uuid){
        if(tipo.equals("fisico")){
            return produtoFisicoService.deletar(uuid);
        } else if(tipo.equals("digital")){
            return produtoDigitalService.deletar(uuid);
        } else if(tipo.equals("intelectual")){
            return produtoIntelectualService.deletar(uuid);
        }
        return "Nenhum Valor achado!!!";
    }

}
