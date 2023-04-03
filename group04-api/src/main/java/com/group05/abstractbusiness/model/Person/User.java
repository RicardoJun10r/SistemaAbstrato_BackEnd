package com.group05.abstractbusiness.model.Person;

import java.util.Objects;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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



    public User(String name ,String login, String password, int permission) {
        super(name);
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


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && permission == user.permission;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, login, password, permission);
    }

}
