package com.group05.abstractbusiness.modules.model.Stock;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.group05.abstractbusiness.modules.model.Business.ProdutoDigital;
import com.group05.abstractbusiness.modules.model.Business.ProdutoIntelectual;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "stock_digi_tb")
@NoArgsConstructor
public class StockDigital extends StockProducts {
    
    @JsonManagedReference
    @OneToMany(targetEntity = ProdutoDigital.class, mappedBy = "stock", cascade = CascadeType.ALL)
    private List<ProdutoDigital> produtosDigitais;

    @JsonManagedReference
    @OneToMany(targetEntity = ProdutoIntelectual.class, mappedBy = "stock", cascade = CascadeType.ALL)
    private List<ProdutoIntelectual> produtoIntelectuais;

    public StockDigital(UUID id, String nome, Integer quantidade, LocalDate createdAt, LocalDate lastUpdated,
            List<ProdutoDigital> produtosDigitais, List<ProdutoIntelectual> produtoIntelectuais){
        super(id, nome, quantidade, createdAt, lastUpdated);
        this.produtosDigitais = produtosDigitais;
        this.produtoIntelectuais = produtoIntelectuais;
    }
    
}
