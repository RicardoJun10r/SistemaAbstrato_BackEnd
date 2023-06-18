package com.group05.abstractbusiness.helper.DTO.person.user;

import lombok.Data;

@Data
public class UserUpdate {
    
    String name;
    
    String oldEmail;

    String newEmail;
    
    String oldPassword;

    String newPassword;

}
