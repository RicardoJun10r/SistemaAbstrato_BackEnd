package com.group05.abstractbusiness.model.Person;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "supplier")
public class Supplier extends Person {

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