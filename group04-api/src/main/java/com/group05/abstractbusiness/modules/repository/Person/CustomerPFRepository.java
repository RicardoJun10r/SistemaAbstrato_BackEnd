package com.group05.abstractbusiness.modules.repository.Person;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group05.abstractbusiness.modules.model.Person.Customers.CustomerPF;

public interface CustomerPFRepository extends JpaRepository<CustomerPF, UUID> {
        Optional<CustomerPF> findByEmail(String email);

}
