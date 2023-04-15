package com.group05.abstractbusiness.controller.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group05.abstractbusiness.service.Person.SupplierService;

@RestController
@RequestMapping("/supplier")
@Validated
public class SupplierController {
    @Autowired
    SupplierService service;

    
}
