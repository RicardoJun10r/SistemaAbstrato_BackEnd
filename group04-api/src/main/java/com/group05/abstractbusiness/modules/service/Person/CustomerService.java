package com.group05.abstractbusiness.modules.service.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group05.abstractbusiness.error.Exception.ResourceBadRequest;
import com.group05.abstractbusiness.helper.DTO.person.customer.CustomerRes;
import com.group05.abstractbusiness.modules.model.Person.IPerson;
import com.group05.abstractbusiness.modules.model.Person.Customers.CustomerFactory;
import com.group05.abstractbusiness.utils.Enums.TipoCostumer;
import com.group05.abstractbusiness.utils.Validator.EmailAndPasswordValidator;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerPFService customerPFService;

    @Autowired
    private CustomerPJService customerPJService;

    @Transactional
    public CustomerRes createCustomer(TipoCostumer tipo, CustomerFactory customerFactory) {

        if(EmailAndPasswordValidator.verifyEmail(customerFactory.getEmail())){
            if(tipo == TipoCostumer.PJ){
                return customerPJService.createCustomerPJ(customerFactory.createCustomerPJ());
            } else {
                return customerPFService.createCustomerPF(customerFactory.createCustomerPF());
            }
        }
        throw new ResourceBadRequest("Verifique o e-mail de customer!");
    }

    public IPerson findCustomerByEmail(TipoCostumer tipo, String email){
        if(EmailAndPasswordValidator.verifyEmail(email)){
            if(tipo == TipoCostumer.PJ){
                return customerPJService.findCustomerPJ(email).get();
            } else {
                return customerPFService.findCustomerPF(email).get();
            }
        }
        throw new ResourceBadRequest("Verifique o e-mail de customer!");
    }

}
