package com.group05.abstractbusiness.modules.repository.Person;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group05.abstractbusiness.modules.model.Person.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, UUID>{
    List<Supplier> findByNameContainingIgnoreCase(String name);
}
