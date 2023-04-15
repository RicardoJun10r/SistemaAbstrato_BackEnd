package com.group05.abstractbusiness.DTO.person;

import java.util.UUID;


import lombok.Data;


@Data
public class UserReturn {
    UUID id;
    String name;
    String login;
    int permission;
}
