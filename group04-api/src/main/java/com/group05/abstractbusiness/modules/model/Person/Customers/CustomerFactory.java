package com.group05.abstractbusiness.modules.model.Person.Customers;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.group05.abstractbusiness.modules.model.Person.Users.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class CustomerFactory {

    UUID uuid;

    LocalDate registerDate;
    
    String name;

    String email;

    String address;

    String phone;

    String cpf;

    String cnpj;

    String company;

    User user;

    public CustomerFactory(){}

    public CustomerFactory(UUID uuid, LocalDate registerDate, String name, String email, String address, String phone, String cnpj, String company) {
        this.uuid = uuid;
        this.registerDate = registerDate;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.cnpj = cnpj;
        this.company = company;
    }

    public CustomerFactory(UUID uuid, LocalDate registerDate,String name, String email, String address, String phone, String cpf) {
        this.uuid = uuid;
        this.registerDate = registerDate;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.cpf = cpf;
    }

    public CustomerPF createCustomerPF(){
        return new CustomerPF(uuid, name, email, registerDate, address, phone, cpf, user);
    }

    public CustomerPJ createCustomerPJ(){
        return new CustomerPJ(uuid, name, email, registerDate, address, phone, cnpj, company, user);
    }
}
