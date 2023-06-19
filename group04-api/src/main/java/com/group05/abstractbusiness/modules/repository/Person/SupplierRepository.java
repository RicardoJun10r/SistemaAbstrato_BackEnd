package com.group05.abstractbusiness.modules.repository.Person;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group05.abstractbusiness.modules.model.Person.Suppliers.Supplier;

import java.util.Optional;


public interface SupplierRepository extends JpaRepository<Supplier, UUID>{
    Optional<Supplier> findByEmail(String email);
}
