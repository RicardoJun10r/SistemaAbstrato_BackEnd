package com.group05.abstractbusiness.group04api.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.group05.abstractbusiness.group04api.Repository.PersonRepository;
import com.group05.abstractbusiness.group04api.Model.Person;

@RestController
@RequestMapping("/person")
public class PersonController {
    

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Person> listAll(){
        return personRepository.findAll();
    }

    @GetMapping("/byId")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<Person> listById(@RequestBody Person person){
        return personRepository.findById(person.getId());
    }

    @GetMapping("/byName")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Person> listByNameLike(@RequestParam("name") String name){
        return personRepository.findByName("%"+ name + "%");
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Person CreatePerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

}
