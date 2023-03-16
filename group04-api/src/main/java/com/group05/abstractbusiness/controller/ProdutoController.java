package com.group05.abstractbusiness.controller;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.group05.abstractbusiness.factory.AbstractFactoryProdutoServico;
import com.group05.abstractbusiness.factory.DigitalFactory;
import com.group05.abstractbusiness.factory.FisicoFactory;
import com.group05.abstractbusiness.factory.IntelectualFactory;
import com.group05.abstractbusiness.model.ProdutoDigital;
import com.group05.abstractbusiness.model.ProdutoFisico;
import com.group05.abstractbusiness.model.ProdutoIntelectual;
import com.group05.abstractbusiness.model.Servico;
import com.group05.abstractbusiness.model.ServicoDigital;
import com.group05.abstractbusiness.model.ServicoFisico;
import com.group05.abstractbusiness.model.ServicoIntelectual;
import com.group05.abstractbusiness.model.Mercadoria;
import com.group05.abstractbusiness.model.Produto;
import com.group05.abstractbusiness.service.ProdutoDigitalService;
import com.group05.abstractbusiness.service.ProdutoFisicoService;
import com.group05.abstractbusiness.service.ProdutoIntelectualService;
import com.group05.abstractbusiness.service.ServicoDigitalService;
import com.group05.abstractbusiness.service.ServicoFisicoService;
import com.group05.abstractbusiness.service.ServicoIntelectualService;


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

    @Autowired
    private ServicoFisicoService serviceFisicoService;

    @Autowired
    private ServicoDigitalService servicoDigitalService;

    @Autowired
    private ServicoIntelectualService servicoIntelectualService;

    private AbstractFactoryProdutoServico fabrica;

    //#region CRIAR PRODUTOS OU SERVIÇOS

    @PostMapping("/fisico/{tipo}")
    public ResponseEntity<Mercadoria> criarFisico(@PathVariable String tipo, @RequestBody FisicoFactory fisicoFactory){
        ModelMapper mapper = new ModelMapper();
        if(tipo.equals("produto")){
            return new ResponseEntity<Mercadoria>(produtoFisicoService.adicionar(mapper.map(fisicoFactory.criarProduto(), ProdutoFisico.class)), HttpStatus.CREATED);
        } else if(tipo.equals("servico")){
            return new ResponseEntity<Mercadoria>(serviceFisicoService.adicionar(mapper.map(fisicoFactory.criarServico(), ServicoFisico.class)), HttpStatus.CREATED);
        }  else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/digital/{tipo}")
    public ResponseEntity<Mercadoria> criarDigital(@PathVariable String tipo, @RequestBody DigitalFactory produto){
        if(tipo.equals("produto")){
            return new ResponseEntity<Mercadoria>(produtoDigitalService.adicionar((ProdutoDigital) produto.criarProduto()), HttpStatus.CREATED);
        } else if(tipo.equals("servico")){
            return new ResponseEntity<Mercadoria>(servicoDigitalService.adicionar((ServicoDigital) produto.criarServico()), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/intelectual/{tipo}")
    public ResponseEntity<Mercadoria> criarIntelectual(@PathVariable String tipo, @RequestBody IntelectualFactory produto){
        if(tipo.equals("produto")){
            return new ResponseEntity<Mercadoria>(produtoIntelectualService.adicionar((ProdutoIntelectual) produto.criarProduto()), HttpStatus.CREATED);
        } else if(tipo.equals("servico")){
            return new ResponseEntity<Mercadoria>(servicoIntelectualService.adicionar((ServicoIntelectual) produto.criarServico()), HttpStatus.CREATED);
        }  else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    //#endregion

}
