package com.group05.abstractbusiness.group04api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.group05.abstractbusiness.group04api.Repository.PersonRepository;
import com.group05.abstractbusiness.group04api.Model.Person;

@RestController
@RequestMapping("/person")
public class PersonController {
    

    @Autowired
    private PersonRepository personRepository;

    @GetMapping()
    public List<Person> listAll(){
        return personRepository.findAll();
    }
    
    @PostMapping
    public Person CreatePerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

}
