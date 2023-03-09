package com.group05.abstractbusiness.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;


import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity                                                     // Anotação de entidade
@Table(name = "person")                                     // Nome da tabela referida
public class Person {
    // id
    @Column(name = "id", unique = true)                  
    @Id                                                     // Anotação do atributo PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // Padrão definido pelo BD
    @NotEmpty
    @NotNull
    private long id;                                        
    
    // name 
    @Column(name = "name",nullable = false)                 // Garantido que o atributo não pode ser null
    @NotEmpty
    @NotNull
    @Size(min = 2, max = 255)
    private String name;                                    
    
    //registerDate
    @Column(name = "register_date", nullable = false)
    @NotEmpty
    @NotNull
    @Temporal(value = TemporalType.TIMESTAMP)               // Tipo do valor de data, poderia ser DATE invés de TIMESTAMP
    @DateTimeFormat(pattern = "dd/MM/yyyy")                 // Padrão da data
    private Timestamp registerDate;


    @PrePersist                                            // Anotação para que o metodo seja executado antes da prescrição no BD, para salvar a registerDate sempre com o horario atual
    protected void onCreate() {
        this.registerDate = new Timestamp(System.currentTimeMillis());
    }

    //Construtor vazio
    public Person() {  
    }

    //Construtor Padrão
    public Person(String name) {
        this.name = name;
    }

    //Retorna Id de Pessoa
    public long getId() {
        return this.id;
    }

    //Seta Id de Pessoa
    public void setId(long id) {
        this.id = id;
    }

    //Retorna nome de Pessoa
    public String getName() {
        return this.name;
    }

    //Seta nome de Pessoa
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
