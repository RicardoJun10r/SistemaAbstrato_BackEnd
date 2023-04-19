package com.group05.abstractbusiness.modules.model.Stock;

import java.time.LocalDate;
import java.util.UUID;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.group05.abstractbusiness.modules.model.Business.ProdutoIntelectual;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "stock_inte_tb")
public class StockIntelectual extends StockProducts {
 
    @JsonManagedReference
    @OneToMany(targetEntity = ProdutoIntelectual.class, mappedBy = "stock", cascade = CascadeType.ALL)
    private List<ProdutoIntelectual> produtosIntelectuais;

    public StockIntelectual(UUID id, String nome, String localizacao, Integer quantidade, LocalDate lastUpdated,
            List<ProdutoIntelectual> produtos) {
        super(id, nome, localizacao, quantidade, lastUpdated);
        this.produtosIntelectuais = produtos;
    }

    public StockIntelectual(List<ProdutoIntelectual> produtos) {
        this.produtosIntelectuais = produtos;
    }

    public StockIntelectual() {}

}
