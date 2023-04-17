package com.group05.abstractbusiness.helper.DTO.person.supplier;

import java.util.UUID;

import lombok.Data;

@Data
public class SupplierReturn {
    UUID id;
    String name;
    String address;
    String email;
    String phone;
}
