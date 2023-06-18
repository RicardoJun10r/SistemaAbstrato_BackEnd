package com.group05.abstractbusiness.modules.model.Person;

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

}
