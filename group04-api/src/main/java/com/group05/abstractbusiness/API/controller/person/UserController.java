package com.group05.abstractbusiness.API.controller.person;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group05.abstractbusiness.helper.DTO.CartReturn;
import com.group05.abstractbusiness.helper.DTO.Business.ProdutoFisicoDTO;
import com.group05.abstractbusiness.helper.DTO.person.user.UserLogin;
import com.group05.abstractbusiness.helper.DTO.person.user.UserPOST;
import com.group05.abstractbusiness.helper.DTO.person.user.UserPUT;
import com.group05.abstractbusiness.helper.DTO.person.user.UserReturn;
import com.group05.abstractbusiness.helper.DTO.transaction.TransactionOutDTO;
import com.group05.abstractbusiness.helper.DTO.transaction.TransactionOutReturn;
import com.group05.abstractbusiness.modules.model.Person.User;
import com.group05.abstractbusiness.modules.model.Stock.StockFisico;
import com.group05.abstractbusiness.modules.service.Business.ProdutoFisicoService;
import com.group05.abstractbusiness.modules.service.Person.UserService;
    
@RestController
@RequestMapping("/user")
//@Validated
public class UserController {

    @Autowired
    private UserService service;
    
    @Autowired
    private ProdutoFisicoService productService;
    

    @GetMapping("/{id}")
    public ResponseEntity<UserReturn> findById(@PathVariable UUID id){
        UserReturn user = this.service.findbyId(id);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/name:{name}")
    public ResponseEntity<List<UserReturn>> findByName(@PathVariable String name){
        List<UserReturn> user = this.service.findbyName(name);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/username:{username}")
    public ResponseEntity<UserReturn> findByUsername(@PathVariable String username){
        UserReturn user = this.service.findbyUsername(username);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<UserReturn> createUser(@RequestBody UserPOST user){
        return new ResponseEntity<>(service.createUser(user), HttpStatus.CREATED);
    }

    @PostMapping("{supplierId}")
    public ResponseEntity<Boolean> createProduct(@PathVariable UUID supplierId, @RequestBody ProdutoFisicoDTO product){
        return new ResponseEntity<>(service.createProduct(product, supplierId), HttpStatus.OK);
    }

    @PostMapping("/stock")
    public ResponseEntity<StockFisico> createStock(@RequestBody StockFisico stock){
        return new ResponseEntity<>(service.createStock(stock), HttpStatus.OK);
    }

    @PostMapping("/stock/{stockName}/{productName}")
    public ResponseEntity<StockFisico> addProductOnStock(@PathVariable String stockName, @PathVariable String productName){
        return new ResponseEntity<>(service.addProductStock(stockName, productName), HttpStatus.OK);
    }
    
    @PostMapping("/cart/{idUser}")
    public ResponseEntity<CartReturn> createCart(@PathVariable UUID idUser){
        return new ResponseEntity<>(service.createCart(idUser), HttpStatus.OK);
    }

    @PostMapping("/cart/{idCart}/{productName}")
    public ResponseEntity<CartReturn> addProductOnCart(@PathVariable UUID idCart, @PathVariable String productName){
        return new ResponseEntity<>(service.addProduct(idCart, productName), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody UserLogin user){
        return new ResponseEntity<>(service.authenticate(user), HttpStatus.OK);
    }


    @PostMapping("/transaction/{idCart}")
    public ResponseEntity<TransactionOutReturn> createTransaction(@PathVariable UUID idCart, @RequestBody TransactionOutDTO transaction){
        return new ResponseEntity<>(service.createTransaction(idCart, transaction), HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<UserReturn> updateUser(@RequestBody UserPUT user){
        return new ResponseEntity<>(service.updateUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/deleted:{id}")
    public String deleteUser(@PathVariable UUID id){
        service.deleteUser(id);
        return "User de id [" + id + " ] deletado";   
    }
}
