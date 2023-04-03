package com.group05.abstractbusiness.model.Person;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "supplier")
public class Supplier extends Person {

    // id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_supplier", unique = true, nullable = false)
    private Long id;

    // address
    @Column(name = "address", nullable = false)
    private String address;

    // email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    // phone
    @Column(name = "phone", nullable = false)
    private String phone;

    public Supplier(String name, String address, String email, String phone) {
        super(name);
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public Supplier() {
    }

    public Long getSuppluerId() {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Supplier)) {
            return false;
        }
        Supplier supplier = (Supplier) o;
        return Objects.equals(id, supplier.id) && Objects.equals(address, supplier.address) && Objects.equals(email, supplier.email) && Objects.equals(phone, supplier.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, email, phone);
    }

}