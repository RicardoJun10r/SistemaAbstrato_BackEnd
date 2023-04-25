package com.group05.abstractbusiness.modules.model.Person;

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

    @Column(name = "phone")
    private String phone;

    public Customer(String name, String address, String email, String phone) {
        super(name);
        this.address = address;
        this.email = email;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
}