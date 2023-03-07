package com.group05.abstractbusiness.group04api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group05.abstractbusiness.group04api.Model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
}
