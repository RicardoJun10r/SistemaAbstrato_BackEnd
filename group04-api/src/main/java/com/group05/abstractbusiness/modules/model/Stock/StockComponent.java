package com.group05.abstractbusiness.modules.model.Stock;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class StockComponent {

    private UUID id;

    private String nome;

    private String location;

    private Integer quantidade;

    private LocalDate createdAt;

    private LocalDate lastUpdated;

    public StockComponent(){}

    public StockComponent(UUID id, String nome, String localizacao, Integer quantidade, LocalDate createdAt, LocalDate lastUpdated){
        this.id = id;
        this.nome = nome;
        this.location = localizacao;
        this.quantidade = quantidade;
        this.createdAt = createdAt;
        this.lastUpdated = lastUpdated;
    }

    public StockProducts criarFisico(){
        return new StockFisico(id, nome, quantidade, createdAt, lastUpdated, location, null);
    }

    public StockProducts criarDigital(){
        return new StockDigital(id, nome, quantidade, createdAt, lastUpdated, null, null);
    }

}
