package com.group05.abstractbusiness.DTO.Person;



import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserPOST {
    String name;
    String login;
    String password;
    int permission;
    Timestamp registerDate;
}