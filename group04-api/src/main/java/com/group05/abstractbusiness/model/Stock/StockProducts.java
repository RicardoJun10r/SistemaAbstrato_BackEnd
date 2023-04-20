package com.group05.abstractbusiness.model.Stock;

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
    private String nome;

    @Column(name = "localizacao")
    private String localizacao;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "lastUpdated")
    private LocalDate lastUpdated;

    public StockProducts(){}

    public StockProducts(UUID id, String nome, String localizacao, Integer quantidade, LocalDate lastUpdated) {
        this.id = id;
        this.nome = nome;
        this.localizacao = localizacao;
        this.quantidade = quantidade;
        this.lastUpdated = lastUpdated;
    }

}
