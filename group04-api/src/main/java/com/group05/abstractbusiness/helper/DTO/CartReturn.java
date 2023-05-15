package com.group05.abstractbusiness.helper.DTO;

import java.util.Map;
import java.util.UUID;

import com.group05.abstractbusiness.modules.model.Person.User;

import lombok.Data;

@Data
public class CartReturn {
    UUID id;
    Map<UUID, Integer> products;
    User user;
}
