package com.group05.abstractbusiness.modules.model.Person;

import java.time.LocalDate;
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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class IPerson {

    @Id                                                     
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private UUID id;                                        
    
    @Column(name = "name", nullable = false)                 
    @NotEmpty(message = "Name can not be empty")
    @NotNull
    private String name;                                    
    
    @Column(name = "email", unique = true)
    @NotEmpty(message = "E-mail can not be empty")
    @NotNull
    @Email(message = "E-mail is not valid", regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
    + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
    private String email;
    
    @Column(name = "register_date")
    @Temporal(value = TemporalType.DATE)                
    @DateTimeFormat(pattern = "dd/MM/yyyy")             
    private LocalDate registerDate;

    @PrePersist                                           
    public void onCreate() {
        this.registerDate = LocalDate.now();
    }

}
