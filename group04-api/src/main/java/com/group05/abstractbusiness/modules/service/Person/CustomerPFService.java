package com.group05.abstractbusiness.modules.service.Person;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group05.abstractbusiness.error.Exception.ResourceNotAcceptable;
import com.group05.abstractbusiness.helper.DTO.person.customer.CustomerRes;
import com.group05.abstractbusiness.modules.model.Person.Customers.CustomerPF;
import com.group05.abstractbusiness.modules.repository.Person.CustomerPFRepository;

@Service
public class CustomerPFService {
    
    @Autowired
    private CustomerPFRepository customerPFRepository;

    private ModelMapper mapper = new ModelMapper();

    public CustomerRes createCustomerPF(CustomerPF customerPF){
        
        if(customerPFRepository.findByEmail(customerPF.getEmail()).isPresent()) throw new ResourceNotAcceptable("Customer já existe");
        
        return mapper.map(customerPFRepository.save(customerPF), CustomerRes.class);

    }

    public Optional<CustomerPF> findCustomerPF(String email){
        return customerPFRepository.findByEmail(email);
    }

}
