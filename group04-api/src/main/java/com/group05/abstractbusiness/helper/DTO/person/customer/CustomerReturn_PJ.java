package com.group05.abstractbusiness.helper.DTO.person.customer;

import java.util.UUID;

import lombok.Data;

@Data
public class CustomerReturn_PJ {
    UUID id;
    String name;
    String address;
    String email;
    String phone;
}
