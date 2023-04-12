package com.group05.abstractbusiness.repository.Person;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group05.abstractbusiness.model.Person.CustomerPF;

public interface CustomerPFRepository extends JpaRepository<CustomerPF, UUID>{
    List<CustomerPF> findByNameContainingIgnoreCase(String name);
}
