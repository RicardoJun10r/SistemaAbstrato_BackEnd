package com.group05.abstractbusiness.helper.mapper;

import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.group05.abstractbusiness.helper.DTO.person.user.UserPOST;
import com.group05.abstractbusiness.helper.DTO.person.user.UserReturn;
import com.group05.abstractbusiness.modules.model.Person.User;


@Mapper(componentModel = "spring")
public abstract class UserMapper {
    public static final UserMapper INSTACE = Mappers.getMapper(UserMapper.class);

    public abstract User toUser(UserPOST userPost);

    public abstract UserReturn toUserReturn(User userPost);
   
    public abstract UserReturn toUserReturnOptional(Optional<User> userPost);
}