package com.group05.abstractbusiness.helper.DTO.person.supplier;

import java.time.LocalDate;

import com.group05.abstractbusiness.modules.model.Person.Users.User;

import lombok.Data;

@Data
public class SupplierDTO {

    String name;
    
    String email;

    LocalDate registerDate;
    
    String address;
    
    String phone;

    Double price;

    LocalDate delivery;

    User user;

}
