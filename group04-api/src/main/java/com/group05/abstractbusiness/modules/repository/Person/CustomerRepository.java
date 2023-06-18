package com.group05.abstractbusiness.modules.repository.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group05.abstractbusiness.modules.model.Person.Customer;

public interface CustomerRepository extends JpaRepository<Customer, UUID>{
    List<Customer> findByNameContainingIgnoreCase(String name);
}
