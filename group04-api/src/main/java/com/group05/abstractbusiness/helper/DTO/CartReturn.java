package com.group05.abstractbusiness.helper.DTO;

import java.util.Map;
import java.util.UUID;

import com.group05.abstractbusiness.modules.model.Business.ProdutoFisico;
import com.group05.abstractbusiness.modules.model.Person.User;

import lombok.Data;

@Data
public class CartReturn {
    UUID id;
    Map<ProdutoFisico, Integer> products;
    User user;
}
