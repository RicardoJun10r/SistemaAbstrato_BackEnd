package com.group05.abstractbusiness.model.Person;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customer_PF")
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


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CustomerPF)) {
            return false;
        }
        CustomerPF customerPF = (CustomerPF) o;
        return Objects.equals(cpf, customerPF.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }

}
