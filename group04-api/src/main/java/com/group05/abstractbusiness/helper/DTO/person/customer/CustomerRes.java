package com.group05.abstractbusiness.helper.DTO.person.customer;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CustomerRes {
    
    String name;

    LocalDate registerDate;
    
    String address;
    
    String email;
    
    String phone;

}
