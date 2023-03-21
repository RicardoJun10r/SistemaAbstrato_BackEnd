package com.group05.abstractbusiness.service.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

import com.group05.abstractbusiness.DTO.PersonPostDTO;
import com.group05.abstractbusiness.DTO.PersonPutDTO;
import com.group05.abstractbusiness.exception.BadRequestException;
import com.group05.abstractbusiness.mapper.PersonMapper;
import com.group05.abstractbusiness.model.Person.Person;
import com.group05.abstractbusiness.repository.personRepository.PersonRepository;

@Service
public class PersonService {
    
    @Autowired
    private PersonRepository personRepository;


    public List<Person>listAll(){
        return personRepository.findAll();
    }


    public Person findbyId(Long id){
        Optional<Person> person = this.personRepository.findById(id);
        return person.orElseThrow( ()-> new BadRequestException("Pesso não econtrada pelo  id ->" + id));
    }

    public List<Person> findbyName(String name){
        List<Person> person = this.personRepository.findByName(name);
        if (person.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nenhuma pessoa encontrada com esse nome-> " + name);
        }else{
            return person;
        }
    }

    @Transactional                                                              // Só persiste o dado caso passe todas as informações
    public Person createPerson(PersonPostDTO personDto) {
        Person person = PersonMapper.INSTANCE.toPerson(personDto);              // Cria instancia de Person para receber um padrão DTO
        return personRepository.save(person);
    }

    @Transactional                                                              // Só persiste o dado caso passe todas as informações
    public Person updatePerson(PersonPutDTO personDto){
        try {
            Person personSaved = findbyId(personDto.getId());
            Person person = PersonMapper.INSTANCE.toPerson(personDto);
            person.setId(personSaved.getId());                                  // Garantido que o Id vai ser o mesmo
            person.setRegisterDate(personSaved.getRegisterDate());              // Garantido que a registerD vai ser o mesmo
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
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Não é possivel excluir pois possui dados relacionados ou não foi encontrado ninguém com esse id -> " + id);
        }
    }
}
