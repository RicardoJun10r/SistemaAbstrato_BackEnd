package com.group05.abstractbusiness.mapper;

import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.group05.abstractbusiness.DTO.person.user.UserPOST;
import com.group05.abstractbusiness.DTO.person.user.UserReturn;
import com.group05.abstractbusiness.model.Person.User;


@Mapper(componentModel = "spring")
public abstract class UserMapper {
    public static final UserMapper INSTACE = Mappers.getMapper(UserMapper.class);

    public abstract User toUser(UserPOST userPost);

    public abstract UserReturn toUserReturn(User userPost);
   
    public abstract UserReturn toUserReturnOptional(Optional<User> userPost);
}