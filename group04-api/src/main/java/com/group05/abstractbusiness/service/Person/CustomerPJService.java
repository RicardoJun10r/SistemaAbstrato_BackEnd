package com.group05.abstractbusiness.service.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.group05.abstractbusiness.model.Person.CustomerPF;
import com.group05.abstractbusiness.model.Person.CustomerPJ;
import com.group05.abstractbusiness.repository.Person.CustomerPJRepository;

@Service
public class CustomerPJService {
    
    @Autowired
    private CustomerPJRepository repository;

    public CustomerPJ findbyId(UUID id){
        Optional<CustomerPJ> customers = this.repository.findById(id);
        return customers.orElseThrow( ()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "user não econtrado pelo  id ->" + id));
    }

    public List<CustomerPJ> findbyName(String name){
        List<CustomerPJ> customers = repository.findByNameContainingIgnoreCase(name);
        if (customers.isEmpty()){
            throw new RuntimeException("Pessoa não encontrada " + name + " " + CustomerPF.class.getClass());
        }else{
            return customers;
        }
    }

    @Transactional                                                              // Só persiste o dado caso passe todas as informações
    public CustomerPJ createCustomerPF(CustomerPJ customer) {
        return this.repository.save(customer);
    }

    @Transactional
    public CustomerPJ updateCustomerPF(CustomerPJ customer){
        CustomerPJ newObj = findbyId(customer.getId());
        newObj.setName(customer.getName());
        return this.repository.save(newObj);
    } 

    public void deleteCustomerPF(UUID id){
        try {
            this.repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possivel excluir pois possui dados relacionados");
        }
    }
}
