package com.group05.abstractbusiness.model.Person;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user_system")
public class User extends Person{

    //login
    @Column(name = "login",nullable = false, unique = true)                 // Garantido que o atributo não pode ser null
    @NotEmpty
    @Size(min = 2, max = 30)
    private String login;


    //Password
    @Column(name = "password",nullable = false, unique = false)              // Garantido que o atributo não pode ser null
    @NotEmpty
    @Size(min = 4, max = 30)
    private String password;

    //Permission
    @Column(name = "permission", nullable = false)
    @NotNull
    private int permission;



    public User(String name ,String login, String password, int permission) {
        super(name);
        this.login = login;
        this.password = password;
        this.permission = permission;
    }


    public User() {
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPermission() {
        return this.permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

}
