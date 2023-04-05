package com.group05.abstractbusiness.model.Person;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Long id;

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

    public Long getCustomerId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Customer)) {
            return false;
        }
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(address, customer.address) && Objects.equals(email, customer.email) && Objects.equals(number, customer.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, email, number);
    }

}