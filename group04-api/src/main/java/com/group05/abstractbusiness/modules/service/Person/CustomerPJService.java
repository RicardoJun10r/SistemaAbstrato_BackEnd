package com.group05.abstractbusiness.modules.service.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.group05.abstractbusiness.helper.DTO.person.customer.CustomerDTO_PJ;
import com.group05.abstractbusiness.helper.DTO.person.customer.CustomerReturn_PJ;
import com.group05.abstractbusiness.helper.mapper.CustomerMapper;
import com.group05.abstractbusiness.modules.model.Person.CustomerPJ;
import com.group05.abstractbusiness.modules.repository.Person.CustomerPJRepository;

@Service
public class CustomerPJService {
    
    @Autowired
    private CustomerPJRepository repository;


    public CustomerReturn_PJ findbyId(UUID id){
        return CustomerMapper.INSTACE.toCustomerRtn(this.repository.findById(id).orElseThrow( 
            ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "user não econtrado pelo  id [ " + id + " ]")));
    }

    public CustomerReturn_PJ findbyCnpj(String cnpj){
        return CustomerMapper.INSTACE.toCustomerRtn(this.repository.findByCnpj(cnpj).orElseThrow( 
            ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "user não econtrado pelo  cnpj [ " + cnpj + " ]")));
    }



    public List<CustomerReturn_PJ> findbyName(String name){
        if (this.repository.findByNameContainingIgnoreCase(name).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma pessoa encontrada com o nome -> " + name + " " + CustomerPJ.class.getClass());
        }else{
            List<CustomerReturn_PJ> suppliers = new ArrayList<>();
            for(int i = 0; i <  this.repository.findByNameContainingIgnoreCase(name).size();i++){
                suppliers.add(i, CustomerMapper.INSTACE
                .toCustomerRtn(this.repository.findByNameContainingIgnoreCase(name).get(i)));
            }
            return suppliers;
        }
    }

    @Transactional                                                              // Só persiste o dado caso passe todas as informações
    public CustomerPJ createCustomerPJ(CustomerDTO_PJ customer) {
        return this.repository.save(CustomerMapper.INSTACE.toCustomerPJ(customer));
    }

    @Transactional
    public CustomerReturn_PJ updateCustomerPJ(UUID id,CustomerDTO_PJ customer){
        CustomerPJ newObj = this.repository.findById(id).orElseThrow(
            ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier com id [ " + id  + " ] não encontrado"));
        newObj.setName(customer.getName());
        newObj.setAddress(customer.getAddress());
        newObj.setEmail(customer.getEmail());
        newObj.setPhone(customer.getPhone());
        newObj.setCnpj(customer.getCnpj());
        return CustomerMapper.INSTACE.toCustomerRtn(this.repository.save(newObj));
    } 

    public void deleteCustomerPJ(UUID id){
        try {
            this.repository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Não é possivel excluir pois possui dados relacionados");
        }
    }
}
