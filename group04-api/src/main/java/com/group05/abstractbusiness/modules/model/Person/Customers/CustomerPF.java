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
@Table(name = "customer_pf_tb")
public class CustomerPF extends IsupplierCustomer {

    // @CPF(message = "cheque o CPF")
    @Column(name = "cpf", unique = true, nullable = false)
    private String cpf;

    @JsonBackReference
    @ManyToOne
    private User user;

    public CustomerPF(UUID id, String name, String email, LocalDate registerDate, String address, String phone,
            String cpf, User user) {
        super(id, name, email, registerDate, address, phone);
        this.cpf = cpf;
        this.user = user;
    }

}