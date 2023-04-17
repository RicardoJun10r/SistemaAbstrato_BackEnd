package com.group05.abstractbusiness.helper.DTO.person.customer;

import java.util.UUID;

import lombok.Data;

@Data
public class CustomerReturn_PF {
    UUID id;
    String name;
    String address;
    String email;
    String phone;
}
