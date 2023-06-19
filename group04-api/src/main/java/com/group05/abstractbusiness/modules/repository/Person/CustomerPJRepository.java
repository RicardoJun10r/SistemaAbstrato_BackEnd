package com.group05.abstractbusiness.modules.repository.Person;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group05.abstractbusiness.modules.model.Person.Customers.CustomerPJ;

public interface CustomerPJRepository extends JpaRepository<CustomerPJ, UUID>{
    Optional<CustomerPJ> findByEmail(String email);
}
