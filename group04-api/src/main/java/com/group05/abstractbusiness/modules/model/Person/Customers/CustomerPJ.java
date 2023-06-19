package com.group05.abstractbusiness.modules.model.Person.Customers;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.group05.abstractbusiness.modules.model.Person.IsupplierCustomer;
import com.group05.abstractbusiness.modules.model.Person.Users.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer_pj_tb")
public class CustomerPJ extends IsupplierCustomer {

    // @CNPJ(message = "cheque o CNPJ")
    @Column(name = "cnpj", unique = true, nullable = false)
    private String cnpj;

    @Column(name = "company", nullable = false)
    private String company;

    @JsonBackReference
    @ManyToOne
    private User user;

    public CustomerPJ(UUID id, String name, String email, LocalDate registerDate, String address, String phone,
             String cnpj, String company, User user) {
        super(id, name, email, registerDate, address, phone);
        this.cnpj = cnpj;
        this.company = company;
        this.user = user;
    }

}
