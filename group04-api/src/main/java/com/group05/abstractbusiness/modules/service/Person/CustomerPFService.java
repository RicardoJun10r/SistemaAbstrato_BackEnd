package com.group05.abstractbusiness.modules.service.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
import com.group05.abstractbusiness.modules.model.Person.CustomerPF;
import com.group05.abstractbusiness.modules.repository.Person.CustomerPFRepository;

@Service
public class CustomerPFService {
    
    @Autowired
    private CustomerPFRepository repository;

    public CustomerPF findbyId(UUID id){
        Optional<CustomerPF> customers = this.repository.findById(id);
        return customers.orElseThrow( ()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "user não econtrado pelo  id ->" + id));
    }

    public List<CustomerPF> findbyName(String name){
        List<CustomerPF> customers = repository.findByNameContainingIgnoreCase(name);
        if (customers.isEmpty()){
            throw new RuntimeException("Pessoa não encontrada " + name + " " + CustomerPF.class.getClass());
        }else{
            return customers;
        }
    }

    @Transactional                                                              // Só persiste o dado caso passe todas as informações
    public CustomerPF createCustomerPF(CustomerPF customer) {
        return this.repository.save(customer);
    }

    @Transactional
    public CustomerPF updateCustomerPF(CustomerPF customer){
        CustomerPF newObj = findbyId(customer.getId());
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
