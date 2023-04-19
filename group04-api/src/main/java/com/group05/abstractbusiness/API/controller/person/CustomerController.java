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

import com.group05.abstractbusiness.helper.DTO.person.customer.CustomerDTO_PF;
import com.group05.abstractbusiness.helper.DTO.person.customer.CustomerDTO_PJ;
import com.group05.abstractbusiness.helper.DTO.person.customer.CustomerReturn_PF;
import com.group05.abstractbusiness.helper.DTO.person.customer.CustomerReturn_PJ;
import com.group05.abstractbusiness.helper.DTO.person.supplier.SupplierDTO;
import com.group05.abstractbusiness.helper.DTO.person.supplier.SupplierReturn;
import com.group05.abstractbusiness.modules.model.Person.CustomerPF;
import com.group05.abstractbusiness.modules.model.Person.CustomerPJ;
import com.group05.abstractbusiness.modules.model.Person.Supplier;
import com.group05.abstractbusiness.modules.service.Person.CustomerPFService;
import com.group05.abstractbusiness.modules.service.Person.CustomerPJService;
import com.group05.abstractbusiness.modules.service.Person.SupplierService;

@RestController
@RequestMapping("/customer")
@Validated
public class CustomerController {
    @Autowired
    CustomerPFService servicePF;

    @Autowired
    CustomerPJService servicePJ;


    @GetMapping("/PF/FindById:{id}")
    public ResponseEntity<CustomerReturn_PF> findByIdPF(@PathVariable UUID id){
        CustomerReturn_PF customer = this.servicePF.findbyId(id);
        return ResponseEntity.ok().body(customer);
    }

    @GetMapping("/PJ/FindById::{id}")
    public ResponseEntity<CustomerReturn_PJ> findByIdPJ(@PathVariable UUID id){
        CustomerReturn_PJ customer = this.servicePJ.findbyId(id);
        return ResponseEntity.ok().body(customer);
    }

    @GetMapping("/PF/FindByCpf:{cpf}")
    public ResponseEntity<CustomerReturn_PF> findByCpf(@PathVariable String cpf){
        CustomerReturn_PF customer = this.servicePF.findbyCpf(cpf);
        return ResponseEntity.ok().body(customer);
    }

    @GetMapping("/PF/findByName:{name}")
    public ResponseEntity<List<CustomerReturn_PF>> findByNamePF(@PathVariable String name){
        List<CustomerReturn_PF> customers = this.servicePF.findbyName(name);
        return ResponseEntity.ok().body(customers);
    }
    @GetMapping("/PJ/findByName:{name}")
    public ResponseEntity<List<CustomerReturn_PJ>> findByNamePJ(@PathVariable String name){
        List<CustomerReturn_PJ> customers = this.servicePJ.findbyName(name);
        return ResponseEntity.ok().body(customers);
    }
    
    @PostMapping
    public ResponseEntity<CustomerPF> createCustomerPF(@RequestBody CustomerDTO_PF customer){
        return new ResponseEntity<>(this.servicePF.createCustomerPF(customer), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerPJ> createCustomerPJ(@RequestBody CustomerDTO_PJ customer){
        return new ResponseEntity<>(this.servicePJ.createCustomerPJ(customer), HttpStatus.OK);
    }

    @PutMapping("/PF:{id}")
    public ResponseEntity<CustomerReturn_PF> updateCustomerPF(@RequestBody CustomerDTO_PF customer, @PathVariable UUID id){
        return new ResponseEntity<>(this.servicePF.updateCustomerPF(id,customer), HttpStatus.OK);
    }

    @PutMapping("/PJ:{id}")
    public ResponseEntity<CustomerReturn_PJ> updateCustomerPJ(@RequestBody CustomerDTO_PJ customer, @PathVariable UUID id){
        return new ResponseEntity<>(this.servicePJ.updateCustomerPJ(id,customer), HttpStatus.OK);
    }

    @DeleteMapping("/PF/deleted:{id}")
    public String deleteCustomerPF(@PathVariable UUID id){
        try {
            this.servicePF.deleteCustomerPF(id);
            return "customer de id [ " + id + " ] deletado";
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }
    }

    @DeleteMapping("/PJ/deleted:{id}")
    public String deleteCustomerPJ(@PathVariable UUID id){
        try {
            this.servicePJ.deleteCustomerPJ(id);
            return "customer de id [ " + id + " ] deletado";
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }
    }
}
