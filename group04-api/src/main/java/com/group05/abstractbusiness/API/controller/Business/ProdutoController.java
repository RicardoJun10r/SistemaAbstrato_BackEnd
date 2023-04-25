package com.group05.abstractbusiness.API.controller.Business;

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
import com.group05.abstractbusiness.modules.model.Business.factory.*;
import com.group05.abstractbusiness.helper.DTO.Business.ProdutoDigitalDTO;
import com.group05.abstractbusiness.helper.DTO.Business.ProdutoFisicoDTO;
import com.group05.abstractbusiness.helper.DTO.Business.ProdutoIntelectualDTO;
import com.group05.abstractbusiness.modules.model.Business.*;
import com.group05.abstractbusiness.modules.service.Business.*;


/**
 *  ----------- AJEITAR ----------- 
 *  REFATORAR ESSE CONTROLLER PARA IMPLEMENTAR O PADRÃO DE PROJETO ABSTRACT FACTORY
 */
@RestController
@RequestMapping("/produto")
public class ProdutoController {
    
    @Autowired
    private ProdutoFisicoService produtoFisicoService;

    @Autowired
    private ProdutoDigitalService produtoDigitalService;

    @Autowired
    private ProdutoIntelectualService produtoIntelectualService;

    //#region CRIAR PRODUTOS

    @PostMapping("/{tipo}")
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

    //#region GET PRODUTO

    @GetMapping("/fisico/{uuid}")
    public ResponseEntity<Optional<ProdutoFisicoDTO>> getFisicoById(@PathVariable UUID uuid){
        ModelMapper mapper = new ModelMapper();
        try {
            ProdutoFisicoDTO dto = mapper.map(produtoFisicoService.buscar(uuid).get(), ProdutoFisicoDTO.class);
            return new ResponseEntity<>(Optional.of(dto), HttpStatus.OK); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/digital/{uuid}")
    public ResponseEntity<Optional<ProdutoDigitalDTO>> getDigitalById(@PathVariable UUID uuid){
        ModelMapper mapper = new ModelMapper();
        try {
            ProdutoDigitalDTO dto = mapper.map(produtoDigitalService.buscar(uuid).get(), ProdutoDigitalDTO.class);
            return new ResponseEntity<>(Optional.of(dto), HttpStatus.OK); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/intelectual/{uuid}")
    public ResponseEntity<Optional<ProdutoIntelectualDTO>> getIntelectualById(@PathVariable UUID uuid){
        ModelMapper mapper = new ModelMapper();
        try {
            ProdutoIntelectualDTO dto = mapper.map(produtoIntelectualService.buscar(uuid).get(), ProdutoIntelectualDTO.class);
            return new ResponseEntity<>(Optional.of(dto), HttpStatus.OK); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    //#endregion

    //#region LIST PRODUTOS

    @GetMapping("/fisico")
    public ResponseEntity<List<ProdutoFisico>> listarFisico(){
        try {
            return new ResponseEntity<>(produtoFisicoService.listar(), HttpStatus.OK); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/digital")
    public ResponseEntity<List<ProdutoDigital>> listarDigitalById(){
        try {
            return new ResponseEntity<>(produtoDigitalService.listar(), HttpStatus.OK); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/intelectual")
    public ResponseEntity<List<ProdutoIntelectual>> listarIntelectualById(){
        try {
            return new ResponseEntity<>(produtoIntelectualService.listar(), HttpStatus.OK); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    //#endregion

    //#region DELETE PRODUTO

    @DeleteMapping("/{tipo}/{uuid}")
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

    //#endregion

    //#region GERENCIAR QUANTIDADE

    // @PostMapping("/fisico/{uuid}/{quantidade}")
    // public ResponseEntity<ProdutoFisicoDTO> atualizarQuantidade(@PathVariable UUID uuid, @PathVariable Integer quantidade){
    //     ProdutoFisico produtoFisico = getFisicoById(uuid).getBody().get();
    // }

    //#endregion

}
