package com.group05.abstractbusiness.model.Company;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "company")
public class Company {

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Padrão definido pelo BD
    @Column(name = "id_company")
    private Long id;

    // Nome da empresa
    @Column(name = "name", nullable = false)
    @NotEmpty
    @NotNull
    private String name;

    // Endereço da empresa
    @Column(name = "address", nullable = false)
    @NotEmpty
    @NotNull
    private String address;

    // Número de telefone da empresa
    @Column(name = "phone_number", nullable = false)
    @NotEmpty
    @NotNull
    @Size(min = 8, max = 20)
    private String phoneNumber;

    public Company(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
