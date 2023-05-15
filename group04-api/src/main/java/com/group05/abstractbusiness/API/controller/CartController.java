
//TO-DO
//Consertar problema no mapeamento do User do cart
//Necessário fazer uma busca pelo ID do user recebido
//e instanciar o user do cart com o encontrado na busca 


package com.group05.abstractbusiness.API.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group05.abstractbusiness.helper.DTO.CartReturn;
import com.group05.abstractbusiness.modules.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService service;

    @PostMapping("{idUser}")
    public ResponseEntity<CartReturn> create(@PathVariable UUID idUser){
        return new ResponseEntity<>(service.create(idUser), HttpStatus.OK);
    }

    @PostMapping("/adicionar/{idCart}/{idProduct}")
    public ResponseEntity<CartReturn> addProduct(@PathVariable UUID idCart,@PathVariable UUID idProduct){
        return new ResponseEntity<>(service.addProduct(idCart, idProduct),HttpStatus.OK);
    }


}
