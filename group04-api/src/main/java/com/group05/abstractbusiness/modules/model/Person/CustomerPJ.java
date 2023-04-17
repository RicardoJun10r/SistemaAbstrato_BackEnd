package com.group05.abstractbusiness.modules.model.Person;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
@Entity
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

}
