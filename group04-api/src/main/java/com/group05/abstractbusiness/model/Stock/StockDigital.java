package com.group05.abstractbusiness.model.Stock;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.group05.abstractbusiness.model.Business.ProdutoDigital;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "stock_digi_tb")
public class StockDigital extends StockProducts {
    
    @JsonManagedReference
    @OneToMany(targetEntity = ProdutoDigital.class, mappedBy = "stock", cascade = CascadeType.ALL)
    private List<ProdutoDigital> produtosDigitais;

    public StockDigital(UUID id, String nome, String localizacao, Integer quantidade, LocalDate lastUpdated,
            List<ProdutoDigital> produtos) {
        super(id, nome, localizacao, quantidade, lastUpdated);
        this.produtosDigitais = produtos;
    }

    public StockDigital(List<ProdutoDigital> produtos) {
        this.produtosDigitais = produtos;
    }

    public StockDigital() {}
    
}
