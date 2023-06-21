package com.group05.abstractbusiness.API.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group05.abstractbusiness.helper.DTO.Stock.StockReq;
import com.group05.abstractbusiness.helper.DTO.Stock.StockRes;
import com.group05.abstractbusiness.helper.DTO.person.customer.CustomerDTO;
import com.group05.abstractbusiness.helper.DTO.person.customer.CustomerRes;
import com.group05.abstractbusiness.helper.DTO.person.supplier.SupplierDTO;
import com.group05.abstractbusiness.helper.DTO.person.supplier.SupplierRes;
import com.group05.abstractbusiness.helper.DTO.person.user.UserReq;
import com.group05.abstractbusiness.helper.DTO.person.user.UserRes;
import com.group05.abstractbusiness.helper.DTO.person.user.UserUpdate;
import com.group05.abstractbusiness.modules.model.Person.IPerson;
import com.group05.abstractbusiness.modules.model.Person.Customers.CustomerFactory;
import com.group05.abstractbusiness.modules.service.Person.UserService;
import com.group05.abstractbusiness.utils.Enums.TipoCostumer;
import com.group05.abstractbusiness.utils.Enums.TipoProduto;
    
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @PostMapping
    public ResponseEntity<UserRes> createUser(@RequestBody UserReq user){
        return new ResponseEntity<UserRes>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserRes> findUser(@PathVariable String email){
        return new ResponseEntity<UserRes>(userService.findUserByEmail(email), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<UserRes> updateUser(@RequestBody UserUpdate userUpdate){
        return new ResponseEntity<UserRes>(userService.updateUser(userUpdate), HttpStatus.OK);
    }

    @PutMapping("/updatePassword")
    public ResponseEntity<UserRes> updatePassword(@RequestBody UserUpdate userUpdate){
        return new ResponseEntity<UserRes>(userService.updatePassword(userUpdate), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestBody UserReq userReq){
        return new ResponseEntity<String>(userService.deleteUser(userReq), HttpStatus.OK);
    }

    @PostMapping("/supplier/{email}")
    public ResponseEntity<SupplierRes> createSupplier(
        @PathVariable String email,
        @RequestBody SupplierDTO supplierDTO){
        return new ResponseEntity<SupplierRes>(userService.createSupplier(email, supplierDTO), HttpStatus.CREATED);
    }

    @GetMapping("/supplier/{email}")
    public ResponseEntity<List<SupplierRes>> findAllSupplier(
        @PathVariable String email){
        return new ResponseEntity<List<SupplierRes>>(userService.findAllSupplier(email), HttpStatus.OK);
    }

    @GetMapping("/supplier")
    public ResponseEntity<SupplierRes> findSupplier(
        @RequestParam String email){
        return new ResponseEntity<SupplierRes>(userService.findSupplier(email), HttpStatus.OK);
    }

    @PostMapping("/customer/{tipo}/{email}")
    public ResponseEntity<CustomerRes> createCustomer(
        @PathVariable TipoCostumer tipo,
        @PathVariable String email,
        @RequestBody CustomerFactory customerFactory){
        return new ResponseEntity<CustomerRes>(userService.createCustomer(email, tipo, customerFactory), HttpStatus.CREATED);
    }

    @GetMapping("/customer/{tipo}/{userEmail}")
    public ResponseEntity<List<CustomerDTO>> findAllCustomer(
        @PathVariable TipoCostumer tipo,
        @PathVariable String userEmail){
        return new ResponseEntity<List<CustomerDTO>>(userService.findAllCustomer(tipo, userEmail), HttpStatus.OK);
    }

    @GetMapping("/customer/{tipo}")
    public ResponseEntity<IPerson> findCustomer(
        @PathVariable TipoCostumer tipo,
        @RequestParam String email){
        return new ResponseEntity<IPerson>(userService.findCustomer(tipo, email), HttpStatus.OK);
    }

    @PostMapping("/stock/{tipo}/{userEmail}")
    public ResponseEntity<StockRes> createStock(
        @PathVariable TipoProduto tipo,
        @PathVariable String userEmail,
        @RequestBody StockReq stockRes){
        return new ResponseEntity<StockRes>(userService.createStock(userEmail, tipo, stockRes), HttpStatus.CREATED);
    }

    @GetMapping("/stock/{tipo}/{userEmail}")
    public ResponseEntity<List<StockRes>> findAllStock(
        @PathVariable TipoProduto tipo,
        @PathVariable String userEmail){
        return new ResponseEntity<List<StockRes>>(userService.findAllStock(userEmail, tipo), HttpStatus.OK);
    }

    @GetMapping("/stock/{tipo}/{userEmail}/{id}")
    public ResponseEntity<StockRes> findStock(
        @PathVariable TipoProduto tipo,
        @PathVariable String userEmail,
        @PathVariable UUID id){
        return new ResponseEntity<StockRes>(userService.findStock(userEmail, tipo, id), HttpStatus.OK);
    }

}
