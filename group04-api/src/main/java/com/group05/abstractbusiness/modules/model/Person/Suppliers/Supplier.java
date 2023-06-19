package com.group05.abstractbusiness.modules.model.Person.Suppliers;
import java.time.LocalDate;

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
@Table(name = "supplier_tb")
public class Supplier extends IsupplierCustomer {

    @Column(name = "price")
    private Double price;

    @Column(name = "delivery_date")
    private LocalDate delivery;

    @JsonBackReference
    @ManyToOne
    private User user;

}