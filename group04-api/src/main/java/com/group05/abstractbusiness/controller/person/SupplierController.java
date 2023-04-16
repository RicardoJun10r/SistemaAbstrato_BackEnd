package com.group05.abstractbusiness.controller.person;

import java.util.List;
import java.util.UUID;

import org.modelmapper.internal.bytebuddy.asm.Advice.Return;
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

import com.group05.abstractbusiness.model.Person.Supplier;
import com.group05.abstractbusiness.service.Person.SupplierService;

@RestController
@RequestMapping("/supplier")
@Validated
public class SupplierController {
    @Autowired
    SupplierService service;

    @GetMapping("{id}")
    public ResponseEntity<Supplier> findById(@PathVariable UUID id){
        Supplier supplier = this.service.findbyId(id);
        return ResponseEntity.ok().body(supplier);
    }

    @GetMapping("/name:{name}")
    public ResponseEntity<List<Supplier>> findByName(@PathVariable String name){
        List<Supplier> suppliers = this.service.findbyName(name);
        return ResponseEntity.ok().body(suppliers);
    }
    
    @PostMapping
    public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier){
        return new ResponseEntity<>(this.service.createSupplier(supplier), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Supplier> updateSupplier(@RequestBody Supplier supplier){
        return new ResponseEntity<>(this.service.updateSupplier(supplier), HttpStatus.OK);
    }

    @DeleteMapping("/deleted:{id}")
    public String deleteSuplier(@PathVariable UUID id){
        try {
            this.service.deleteSupplier(id);
            return "supplier de id [ " + id + " ] deletado";
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }
    }
}
