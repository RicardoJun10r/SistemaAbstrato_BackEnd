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

import com.group05.abstractbusiness.helper.DTO.person.user.UserPOST;
import com.group05.abstractbusiness.helper.DTO.person.user.UserPUT;
import com.group05.abstractbusiness.helper.DTO.person.user.UserReturn;
import com.group05.abstractbusiness.modules.service.Person.UserService;
    
@RestController
@RequestMapping("/user")
//@Validated
public class UserController {

    @Autowired
    private UserService service;

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

    @PostMapping
    public ResponseEntity<UserReturn> createUser(@RequestBody UserPOST user){
        return new ResponseEntity<>(service.createUser(user), HttpStatus.CREATED);
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
