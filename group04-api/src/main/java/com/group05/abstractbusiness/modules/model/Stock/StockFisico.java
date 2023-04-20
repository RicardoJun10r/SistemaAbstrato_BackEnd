package com.group05.abstractbusiness.modules.model.Stock;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.group05.abstractbusiness.modules.model.Business.ProdutoFisico;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "stock_fisi_tb")
public class StockFisico extends StockProducts {
    
    @JsonManagedReference
    @OneToMany(targetEntity = ProdutoFisico.class, mappedBy = "stock", cascade = CascadeType.ALL)
    private List<ProdutoFisico> produtosFisicos;

    public StockFisico(UUID id, String nome, String localizacao, Integer quantidade, LocalDate lastUpdated,
            List<ProdutoFisico> produtos) {
        super(id, nome, localizacao, quantidade, lastUpdated);
        this.produtosFisicos = produtos;
    }

    public StockFisico(List<ProdutoFisico> produtos) {
        this.produtosFisicos = produtos;
    }

    public StockFisico() {}

}
