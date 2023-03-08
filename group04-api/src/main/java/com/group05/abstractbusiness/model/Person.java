package com.group05.abstractbusiness.model;

import java.util.Objects;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.domain.Sort;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity                                                     // Anotação de entidade
@Table(name = "person")                                     // Nome da tabela referida
public class Person {
    @Id                                                     // Anotação do atributo PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // Padrão definido pelo BD
    @Column(name = "id", unique = true)
    private long id;                                        // id
    
    @Column(name = "name",nullable = false)                 // Garantido que o atributo não pode ser null
    private String name;                                    // name 


    public Person() {
    }

    public Person(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
