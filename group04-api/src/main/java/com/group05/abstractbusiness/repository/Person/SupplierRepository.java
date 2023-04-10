package com.group05.abstractbusiness.repository.Person;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.group05.abstractbusiness.model.Person.Supplier;

@Repository
public interface SupplierRepository extends PersonRepository<Supplier>{
    @Override
    @Query("SELECT s FROM supplier s WHERE translate(lower(s.name), 'áàãâéêíóôõúüç','aaaaeeiooouuc') LIKE %:name%")       //Deixa tudo em minusculo e sem acento
    public List<Supplier> findByName(@Param("name") String name);
}
