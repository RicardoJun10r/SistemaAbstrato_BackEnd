package com.group05.abstractbusiness.modules.model.Person;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name = "customer_tb")
public class Customer extends IsupplierCustomer {   

    @Column(name = "customer_type", nullable = false)
    private Boolean customerType;

    @Column(name = "cpf_or_cnpj", unique = true, nullable = false)
    private String cpf_cnpj;

    @JsonBackReference
    @ManyToOne
    private User user_customer;

}