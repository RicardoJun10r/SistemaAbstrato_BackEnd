package com.group05.abstractbusiness.helper.DTO.person.supplier;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SupplierRes {

    String name;
    
    String address;
    
    String email;
    
    String phone;

    LocalDate delivery;

}
