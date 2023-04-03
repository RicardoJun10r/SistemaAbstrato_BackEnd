package com.group05.abstractbusiness.model.Person;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_PJ")
public class CustomerPJ extends Customer{
    @Column(nullable = false, unique = true, name = "Cnpj")
    private String cnpj;
    
    public CustomerPJ() {
        super();
    }

    public CustomerPJ(String name, String address, String email, String number, String cnpj) {
        super(name, address, email, number);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CustomerPJ)) {
            return false;
        }
        CustomerPJ customerPJ = (CustomerPJ) o;
        return Objects.equals(cnpj, customerPJ.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cnpj);
    }

}
