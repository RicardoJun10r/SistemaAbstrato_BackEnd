package com.group05.abstractbusiness.modules.repository.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group05.abstractbusiness.modules.model.Person.CustomerPJ;

public interface CustomerPJRepository extends JpaRepository<CustomerPJ, UUID>{
    List<CustomerPJ> findByNameContainingIgnoreCase(String name);
    Optional<CustomerPJ> findByCnpj(String cnpj);
}
