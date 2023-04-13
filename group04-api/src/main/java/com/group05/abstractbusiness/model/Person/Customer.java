package com.group05.abstractbusiness.model.Person;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "customer")
public class Customer extends Person {    
    @Column(name = "address")
    private String address;
    
    @Column(name = "email")
    private String email;

    @Column(name = "number")
    private String number;

    public Customer(String name, String address, String email, String number) {
        super(name);
        this.address = address;
        this.email = email;
        this.number = number;
    }

    public Customer() {
        super();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }
    
    public void setNumber(String number) {
        this.number = number;
    }
}