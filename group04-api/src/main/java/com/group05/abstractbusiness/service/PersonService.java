package com.group05.abstractbusiness.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import javax.management.RuntimeErrorException;

import com.group05.abstractbusiness.model.Person;
import com.group05.abstractbusiness.repository.PersonRepository;

@Service
public class PersonService {
    
    @Autowired
    private PersonRepository personRepository;

    public Person findbyId(Long id){
        Optional<Person> person = this.personRepository.findById(id);
        return person.orElseThrow( ()-> new RuntimeException(
            "Pessoa não econtrada" + id + "Tipo: " + Person.class.getName())
            );
    }

    public List<Person> findbyName(String name){
        List<Person> person = this.personRepository.findByName(name);
        if (person.isEmpty()){
            throw new RuntimeException("Pessoa não encontrada " + name + " " + Person.class.getClass());
        }else{
            return person;
        }
    }

    @Transactional                                                              // Só persiste o dado caso passe todas as informações
    public Person CreatePerson(Person person) {
        person.setId(0);
        return this.personRepository.save(person);
    }

    @Transactional
    public Person UpdatePerson(Person person){
        Person newObj = findbyId(person.getId());
        newObj.setName(person.getName());
        return this.personRepository.save(newObj);
    }

    public void DeletePerson(Long id){
        try {
            this.personRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possivel excluir pois possui dados relacionados");
        }
    }
}
