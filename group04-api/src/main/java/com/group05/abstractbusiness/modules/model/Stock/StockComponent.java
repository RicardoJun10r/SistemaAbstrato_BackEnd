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

    private String localizacao;

    private Integer quantidade;

    private LocalDate lastUpdated;

    public StockComponent(){}

    public StockComponent(UUID id, String nome, String localizacao, Integer quantidade, LocalDate lastUpdated){
        this.id = id;
        this.nome = nome;
        this.localizacao = localizacao;
        this.quantidade = quantidade;
        this.lastUpdated = lastUpdated;
    }

    public StockProducts criarFisico(){
        return new StockFisico(id, nome, localizacao, quantidade, lastUpdated, null);
    }

    public StockProducts criarDigital(){
        return new StockDigital(id, nome, localizacao, quantidade, lastUpdated, null);
    }

    public StockProducts criarIntelectual(){
        return new StockIntelectual(id, nome, localizacao, quantidade, lastUpdated, null);
    }
}
