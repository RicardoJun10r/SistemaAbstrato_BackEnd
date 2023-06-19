package com.group05.abstractbusiness.helper.DTO.person.customer;

import java.time.LocalDate;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@MappedSuperclass
@EqualsAndHashCode
public abstract class CustomerDTO {
    
    String name;

    LocalDate registerDate;
    
    String address;
    
    String email;
    
    String phone;
    
}
