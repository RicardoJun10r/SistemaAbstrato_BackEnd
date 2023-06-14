package com.group05.abstractbusiness.modules.model.Stock;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class StockProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private UUID id;

    @Column(name = "nome")
    private String name;

    @Column(name = "localizacao")
    private String location;

    @Column(name = "quantidade")
    private Integer quantity;

    @Column(name = "lastUpdated")
    private LocalDate lastUpdated;

    public StockProducts(){}

    public StockProducts(UUID id, String nome, String localizacao, Integer quantidade, LocalDate lastUpdated){
        this.id = id;
        this.name = nome;
        this.location = localizacao;
        this.quantity = quantidade;
        this.lastUpdated = lastUpdated;
    }
    
}
