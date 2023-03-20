package com.group05.abstractbusiness.service.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

import com.group05.abstractbusiness.DTO.PersonPostDTO;
import com.group05.abstractbusiness.DTO.PersonPutDTO;
import com.group05.abstractbusiness.model.Person.Person;
import com.group05.abstractbusiness.repository.PersonRepository.PersonRepository;

@Service
public class PersonService {
    
    @Autowired
    private PersonRepository personRepository;


    public List<Person>listAll(){
        return personRepository.findAll();
    }


    public Person findbyId(Long id){
        Optional<Person> person = this.personRepository.findById(id);
        return person.orElseThrow( ()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pesso não econtrada pelo  id ->" + id));
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
    public Person createPerson(PersonPostDTO personDto) {
        Person person = Person.builder().name(personDto.getName()).build();     // Cria instancia de Person para receber um padrão DTO
        return personRepository.save(person);
    }

    @Transactional                                                              // Só persiste o dado caso passe todas as informações
    public Person updatePerson(PersonPutDTO personDto){
        try {
            Person personSaved = findbyId(personDto.getId());
            Person person = Person.builder()                                        // Cria instancia de Person para receber um padrão DTO
                .id(personSaved.getId()) 
                .name(personDto.getName())
                .registerDate(personSaved.getRegisterDate())
                .build();
            return personRepository.save(person);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    } 

    public void deletePerson(Long id){
        try {
            findbyId(id);
            this.personRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possivel excluir pois possui dados relacionados ou não foi encontrado ninguém com esse id -> " + id);
        }
    }
}
