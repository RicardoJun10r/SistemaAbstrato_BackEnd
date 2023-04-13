package com.group05.abstractbusiness.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.group05.abstractbusiness.DTO.Person.UserPOST;
import com.group05.abstractbusiness.DTO.Person.UserReturn;
import com.group05.abstractbusiness.model.Person.User;


@Mapper(componentModel = "spring")
public abstract class UserMapper {
    public static final UserMapper INSTACE = Mappers.getMapper(UserMapper.class);

    public abstract User toUser(UserPOST userPost);

    public abstract UserReturn toUserReturn(User userPost);
    
}
