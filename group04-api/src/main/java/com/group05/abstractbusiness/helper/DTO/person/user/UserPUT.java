package com.group05.abstractbusiness.helper.DTO.person.user;


import java.util.UUID;
import lombok.Data;

@Data
public class UserPUT {
    UUID id;
    String name;
    String login;
    String password;
}