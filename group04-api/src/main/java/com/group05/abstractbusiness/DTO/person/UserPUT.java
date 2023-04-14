package com.group05.abstractbusiness.DTO.person;



import java.sql.Timestamp;
import java.util.UUID;

import lombok.Data;
@Data
public class UserPUT {
    UUID id;
    String name;
    String login;
    String password;
}