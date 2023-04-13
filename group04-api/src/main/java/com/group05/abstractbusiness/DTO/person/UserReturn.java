package com.group05.abstractbusiness.DTO.person;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReturn {
    UUID id;
    String name;
    String login;
    int permission;
}
