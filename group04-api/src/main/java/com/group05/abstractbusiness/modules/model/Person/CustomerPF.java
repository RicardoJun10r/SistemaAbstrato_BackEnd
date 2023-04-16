package com.group05.abstractbusiness.modules.model.Person;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.PrimaryKeyJoinColumns;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class CustomerPF extends Customer{
        
    @Column(nullable = false, unique = true, name = "Cpf")
    private String cpf;
    
    public CustomerPF() {
        super();
    }

    public CustomerPF(String name, String address, String email, String number, String cpf) {
        super(name, address, email, number);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
