package com.group05.abstractbusiness.DTO.person;



import java.sql.Timestamp;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPOST {
    String name;
    String login;
    String password;
    int permission;
    Timestamp registerDate;
}