package com.group05.abstractbusiness.repository.Person;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.group05.abstractbusiness.model.Person.Customer;

@Repository
public interface CustomerRepository<C extends Customer> extends PersonRepository<C>{
    @Override
    @Query("SELECT us FROM customer us WHERE translate(lower(us.name), 'áàãâéêíóôõúüç','aaaaeeiooouuc') LIKE %:name%")       //Deixa tudo em minusculo e sem acento
    public List<C> findByName(@Param("name") String name);
}
