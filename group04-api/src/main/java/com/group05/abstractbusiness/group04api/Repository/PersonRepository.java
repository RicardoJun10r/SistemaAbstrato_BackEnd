package com.group05.abstractbusiness.group04api.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.group05.abstractbusiness.group04api.Model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
    //Função para fazer busca de pessoa pelo nome
    @Query("SELECT p FROM Person p WHERE translate(lower(p.name), 'áàãâéêíóôõúüç','aaaaeeiooouuc') LIKE %:name%")       //Deixa tudo em minusculo e sem acento
    public List<Person> findByName(@Param("name") String name);
    
}
