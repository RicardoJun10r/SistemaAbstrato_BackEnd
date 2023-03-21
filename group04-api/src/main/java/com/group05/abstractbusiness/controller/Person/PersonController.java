package com.group05.abstractbusiness.controller.Person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group05.abstractbusiness.DTO.PersonPostDTO;
import com.group05.abstractbusiness.DTO.PersonPutDTO;
import com.group05.abstractbusiness.model.Person.Person;
import com.group05.abstractbusiness.service.person.PersonService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("person")  
@Validated
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity<List<Person>> list(){
        return ResponseEntity.ok(personService.listAll());
    }

    @GetMapping("/id:{id}")
    public ResponseEntity<Person> findById(@PathVariable Long id){                      //Pode substituir por @RequestParam
        Person person = this.personService.findbyId(id);
        return ResponseEntity.ok().body(person);
    }

    @GetMapping("/name:{name}")
    public ResponseEntity<List<Person>> findByName(@PathVariable String name){          //Pode substituir por @RequestParam
        List<Person> person = this.personService.findbyName(name);
        return ResponseEntity.ok().body(person);
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody @Valid PersonPostDTO person){
        return new ResponseEntity<>(personService.createPerson(person), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Person> updatePerson(@RequestBody @Valid PersonPutDTO person){
        return new ResponseEntity<>(personService.updatePerson(person), HttpStatus.OK);
    }
}
