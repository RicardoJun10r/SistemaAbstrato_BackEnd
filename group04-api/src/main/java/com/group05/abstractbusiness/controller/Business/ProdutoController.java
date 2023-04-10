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

    @GetMapping("/fisico/{uuid}")
    public Optional<ProdutoFisico> getFisicoById(@PathVariable UUID uuid){
        try {
            return produtoFisicoService.buscar(uuid); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/digital/{uuid}")
    public Optional<ProdutoDigital> getDigitalById(@PathVariable UUID uuid){
        try {
            return produtoDigitalService.buscar(uuid); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/intelectual/{uuid}")
    public Optional<ProdutoIntelectual> getIntelectualById(@PathVariable UUID uuid){
        try {
            return produtoIntelectualService.buscar(uuid); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/fisico")
    public List<ProdutoFisico> listarFisico(){
        try {
            return produtoFisicoService.listar(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/digital")
    public List<ProdutoDigital> listarDigitalById(){
        try {
            return produtoDigitalService.listar(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/intelectual")
    public List<ProdutoIntelectual> listarIntelectualById(){
        try {
            return produtoIntelectualService.listar(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("/fisico/{uuid}")
    public String deleteFisicoById(@PathVariable UUID uuid){
        return produtoFisicoService.deletar(uuid); 
    }

    @DeleteMapping("/digital/{uuid}")
    public String deletegetDigitalById(@PathVariable UUID uuid){
        return produtoDigitalService.deletar(uuid); 
    }

    @DeleteMapping("/intelectual/{uuid}")
    public String deletegetIntelectualById(@PathVariable UUID uuid){
        return produtoIntelectualService.deletar(uuid); 
    }

}
