package com.group05.abstractbusiness.modules.service.Person;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group05.abstractbusiness.error.Exception.ResourceNotAcceptable;
import com.group05.abstractbusiness.helper.DTO.person.customer.CustomerRes;
import com.group05.abstractbusiness.modules.model.Person.Customers.CustomerPJ;
import com.group05.abstractbusiness.modules.repository.Person.CustomerPJRepository;

@Service
public class CustomerPJService {

    @Autowired
    private CustomerPJRepository customerPJRepository;
    
    private ModelMapper mapper = new ModelMapper();

    public CustomerRes createCustomerPJ(CustomerPJ customerPJ){
        
        if(customerPJRepository.findByEmail(customerPJ.getEmail()).isPresent()) throw new ResourceNotAcceptable("Customer já existe");
        
        return mapper.map(customerPJRepository.save(customerPJ), CustomerRes.class);

    }

    public Optional<CustomerPJ> findCustomerPJ(String email){
        return customerPJRepository.findByEmail(email);
    }

}
