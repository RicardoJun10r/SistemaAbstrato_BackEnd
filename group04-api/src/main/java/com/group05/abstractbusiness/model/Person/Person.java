package com.group05.abstractbusiness.model.Person;

import java.sql.Timestamp;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@MappedSuperclass
public abstract class Person {
    // id
    @Column(name = "id", unique = true)                  
    @Id                                                     // Anotação do atributo PK
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;                                        
    
    // name 
    @Column(name = "name",nullable = false)                 // Garantido que o atributo não pode ser null
    @NotEmpty
    @NotNull
    @Size(min = 2, max = 255)
    private String name;                                    
    
    //registerDate
    @Column(name = "register_date", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)               // Tipo do valor de data, poderia ser DATE invés de TIMESTAMP
    @DateTimeFormat(pattern = "dd/MM/yyyy")                 // Padrão da data
    private Timestamp registerDate;


    @PrePersist                                            // Anotação para que o metodo seja executado antes da prescrição no BD, para salvar a registerDate sempre com o horario atual
    public void onCreate() {
        this.registerDate = new Timestamp(System.currentTimeMillis());
    }

    //Construtor vazio
    protected Person() {  
    }

    //Construtor Padrão
    protected Person(String name) {
        this.name = name;
    }

    //Retorna Id de Pessoa
    public UUID getId() {
        return this.id;
    }

    //Seta Id de Pessoa
    public void setId(UUID id) {
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
}
