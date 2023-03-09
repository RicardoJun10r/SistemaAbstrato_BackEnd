package com.group05.abstractbusiness.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class User extends Person{
    //id
    @Id
    @Column(name = "id_user", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)                     // Padrão definido pelo BD
    @NotEmpty
    @NotNull
    private Long userId;


    //login
    @Column(name = "login",nullable = false, unique = true)                 // Garantido que o atributo não pode ser null
    @NotEmpty
    @NotNull
    @Size(min = 2, max = 30)
    private String login;


    //Password
    @Column(name = "password",nullable = false, unique = false)              // Garantido que o atributo não pode ser null
    @NotEmpty
    @NotNull
    @Size(min = 4, max = 30)
    private String password;

    //Permission
    @Column(name = "permission", nullable = false)
    @NotEmpty
    @NotNull
    private int permission;



    public User( String login, String password, int permission) {
        this.login = login;
        this.password = password;
        this.permission = permission;
    }


    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
