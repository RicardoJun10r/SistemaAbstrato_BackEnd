package com.group05.abstractbusiness.modules.model.Stock;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class StockProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private UUID id;

    @Column(name = "nome")
    private String name;

    @Column(name = "quantidade")
    private Integer quantity;

    @Column(name = "created_date")
    private LocalDate createdAt;

    @Column(name = "lastUpdated")
    private LocalDate updatedAt;

    @PrePersist
    private void onCreate(){
        this.createdAt = LocalDate.now();
    }
    
}
