package com.group05.abstractbusiness.service.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

import com.group05.abstractbusiness.model.Person.Person;
import com.group05.abstractbusiness.model.Person.User;
import com.group05.abstractbusiness.repository.Person.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public User findbyId(UUID id){
        Optional<User> user = this.repository.findById(id);
        return user.orElseThrow( ()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "user não econtrado pelo  id ->" + id));
    }

    public List<User> findbyName(String name){
        List<User> users = repository.findByNameContainingIgnoreCase(name);
        if (users.isEmpty()){
            throw new RuntimeException("Pessoa não encontrada " + name + " " + Person.class.getClass());
        }else{
            return users;
        }
    }

    @Transactional                                                              // Só persiste o dado caso passe todas as informações
    public User createUser(User user) {
        return this.repository.save(user);
    }

    @Transactional
    public User updateUser(User user){
        User newObj = findbyId(user.getId());
        newObj.setName(user.getName());
        return this.repository.save(newObj);
    } 

    public void deletePerson(UUID id){
        try {
            this.repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possivel excluir pois possui dados relacionados");
        }
    }
}
