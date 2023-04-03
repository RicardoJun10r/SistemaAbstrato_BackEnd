package com.group05.abstractbusiness.model.Person;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity                                                     // Anotação de entidade
@Table(name = "person")                                     // Nome da tabela referida
public class Person {
    // id
    @Column(name = "id", unique = true)                  
    @Id                                                     // Anotação do atributo PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // Padrão definido pelo BD
    private long id;                                        
    
    // name 
    @Column(name = "name",nullable = false)                 // Garantido que o atributo não pode ser null
    @NotEmpty
    @NotNull
    @Size(min = 2, max = 255)
    private String name;                                    
    
    //registerDate
    @Column(name = "register_date", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)               // Tipo do valor de data, poderia ser DATE invés de TIMESTAMP
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm")           // Padrão da data
    private LocalDateTime registerDate;


    public Person(String name) {
        this.name = name;
        this.registerDate = LocalDateTime.now();
    }

    @PrePersist                                            // Anotação para que o metodo seja executado antes da prescrição no BD, para salvar a registerDate sempre com o horario atual
    protected void onCreate() {
        this.registerDate = LocalDateTime.now();
    }



    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name) && Objects.equals(registerDate, person.registerDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, registerDate);
    }


}
