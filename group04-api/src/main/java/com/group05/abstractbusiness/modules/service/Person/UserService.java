package com.group05.abstractbusiness.modules.service.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;


import com.group05.abstractbusiness.DTO.person.*;
import com.group05.abstractbusiness.DTO.person.user.UserPOST;
import com.group05.abstractbusiness.DTO.person.user.UserPUT;
import com.group05.abstractbusiness.DTO.person.user.UserReturn;
import com.group05.abstractbusiness.mapper.UserMapper;
import com.group05.abstractbusiness.modules.model.Person.User;
import com.group05.abstractbusiness.modules.repository.Person.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public UserReturn findbyId(UUID id){
        this.repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "User com o id [ "+ id + " ] não encontrado"));
        return UserMapper.INSTACE.toUserReturnOptional(this.repository.findById(id));
    }

    public List<UserReturn> findbyName(String name){
        if (this.repository.findByNameContainingIgnoreCase(name).isEmpty()){
            throw new RuntimeException("Pessoa não encontrada " + name + " " + User.class.getClass());
        }else{
            List<UserReturn> users = new ArrayList<>();
            for(int i = 0; i < this.repository.findByNameContainingIgnoreCase(name).size();i++){
            users.add(i, UserMapper.INSTACE.toUserReturn(this.repository.findByNameContainingIgnoreCase(name).get(i)));
            }
            return users;
        }
    }

    @Transactional                                           // Só persiste o dado caso passe todas as informações
    public UserReturn createUser(UserPOST user) {
        return UserMapper.INSTACE.toUserReturn(this.repository.save(UserMapper.INSTACE.toUser(user)));
    }

    @Transactional
    public UserReturn updateUser(UserPUT user){
        User userFind = this.repository.findById(user.getId())
        .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "User com o id [ "+ user.getId() + " ] não encontrado"));
        
        // Validando password
        if(userFind.getPassword().equals(user.getPassword())){
            userFind.setName(user.getName());               // Atualizando Nome
            userFind.setLogin(user.getLogin());             // Atualizando Login
            return UserMapper.INSTACE.toUserReturn(this.repository.save(userFind));
        }else{
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "Password incorreto");
        }
    } 

    public void deleteUser(UUID id){
        if(this.repository.existsById(id)){
            repository.deleteById(id);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User com id [ " + id + " ] não encontrado");
        }
    }
}
