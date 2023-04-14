package com.group05.abstractbusiness.model.Stock;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.group05.abstractbusiness.model.Business.Produto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "stock_tb")
public class StockProducts {

    private UUID id;

    private String nome;

    private String localizacao;

    private Integer quantidade;

    private LocalDate lastUpdated;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "stock_id")
    private List<Produto> produtos;

    public StockProducts() {}

    public StockProducts(UUID id, String nome, String localizacao, Integer quantidade, LocalDate lastUpdated,
            List<Produto> produtos) {
        this.id = id;
        this.nome = nome;
        this.localizacao = localizacao;
        this.quantidade = quantidade;
        this.lastUpdated = lastUpdated;
        this.produtos = produtos;
    }

}
