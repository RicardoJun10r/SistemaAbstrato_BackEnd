package com.group05.abstractbusiness.modules.service.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.group05.abstractbusiness.helper.DTO.person.customer.CustomerDTO_PF;
import com.group05.abstractbusiness.helper.DTO.person.customer.CustomerReturn_PF;
import com.group05.abstractbusiness.helper.mapper.CustomerMapper;
import com.group05.abstractbusiness.modules.model.Person.CustomerPF;
import com.group05.abstractbusiness.modules.repository.Person.CustomerPFRepository;

@Service
public class CustomerPFService {
    
    @Autowired
    private CustomerPFRepository repository;


    public CustomerReturn_PF findbyId(UUID id){
        return CustomerMapper.INSTACE.toCustomerRtn(this.repository.findById(id).orElseThrow( 
            ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "user não econtrado pelo  id [ " + id + " ]")));
    }

    public CustomerReturn_PF findbyCpf(String cpf){
        return CustomerMapper.INSTACE.toCustomerRtn(this.repository.findByCpf(cpf).orElseThrow( 
            ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "user não econtrado pelo  id [ " + cpf + " ]")));
    }


    public List<CustomerReturn_PF> findbyName(String name){
        if (this.repository.findByNameContainingIgnoreCase(name).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma pessoa encontrada com o nome -> " + name + " " + CustomerPF.class.getClass());
        }else{
            List<CustomerReturn_PF> suppliers = new ArrayList<>();
            for(int i = 0; i <  this.repository.findByNameContainingIgnoreCase(name).size();i++){
                suppliers.add(i, CustomerMapper.INSTACE
                .toCustomerRtn(this.repository.findByNameContainingIgnoreCase(name).get(i)));
            }
            return suppliers;
        }
    }

    @Transactional                                                              // Só persiste o dado caso passe todas as informações
    public CustomerPF createCustomerPF(CustomerDTO_PF customer) {
        return this.repository.save(CustomerMapper.INSTACE.toCustomerPF(customer));
    }

    @Transactional
    public CustomerReturn_PF updateCustomerPF(UUID id,CustomerDTO_PF customer){
        CustomerPF newObj = this.repository.findById(id).orElseThrow(
            ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier com id [ " + id  + " ] não encontrado"));
        newObj.setName(customer.getName());
        newObj.setAddress(customer.getAddress());
        newObj.setEmail(customer.getEmail());
        newObj.setPhone(customer.getPhone());
        newObj.setCpf(customer.getCpf());
        return CustomerMapper.INSTACE.toCustomerRtn(this.repository.save(newObj));
    } 

    public void deleteCustomerPF(UUID id){
        try {
            this.repository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Não é possivel excluir pois possui dados relacionados");
        }
    }
}
