package com.group05.abstractbusiness.modules.model.Person;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class IsupplierCustomer extends IPerson {
    
    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    public IsupplierCustomer(UUID id, String name, String email, LocalDate registerDate, String address, String phone) {
        super(id, name, email, registerDate);
        this.address = address;
        this.phone = phone;
    }

}
