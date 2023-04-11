package com.group05.abstractbusiness.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.group05.abstractbusiness.model.Person.Person;

@Repository
public interface PersonRepository <T extends Person> extends JpaRepository<T, UUID>{
    List<T> findByNameContainingIgnoreCase(String name);
}
