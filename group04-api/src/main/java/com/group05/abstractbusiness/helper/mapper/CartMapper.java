package com.group05.abstractbusiness.helper.mapper;

import java.util.Optional;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.group05.abstractbusiness.helper.DTO.CartDTO;
import com.group05.abstractbusiness.helper.DTO.CartReturn;
import com.group05.abstractbusiness.modules.model.Cart;
import com.group05.abstractbusiness.modules.model.Person.User;


@Mapper(componentModel = "spring")
public abstract class CartMapper {
    public static final CartMapper INSTACE = Mappers.getMapper(CartMapper.class);


    public abstract Cart toCart(CartDTO cart);
    public abstract Cart toCart(CartReturn cart);

    public abstract CartDTO toCartDTO(Cart cart);
    public abstract CartReturn toCartReturn(Cart cart);
    public abstract CartDTO toCartDTO(Optional<Cart> cart);
    public abstract CartReturn toCartReturn(Optional<Cart> cart);

    public User map(UUID user){
        User aux = new User();
        aux.setId(user);
        return aux;
    }

    public UUID map(User user){
        UUID aux = user.getId();
        return aux;
    }
}
