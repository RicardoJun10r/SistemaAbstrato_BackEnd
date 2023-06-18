package com.group05.abstractbusiness.modules.model.Stock;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.group05.abstractbusiness.modules.model.Business.ProdutoIntelectual;
import com.group05.abstractbusiness.modules.model.Person.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Table(name = "stock_inte_tb")
@NoArgsConstructor
public class StockIntelectual extends StockProducts {

    @JsonBackReference
    @ManyToOne
    private User user_SI;
    
    @JsonManagedReference
    @OneToMany(targetEntity = ProdutoIntelectual.class, mappedBy = "stockIntelectual", cascade = CascadeType.ALL)
    private List<ProdutoIntelectual> produtoIntelectuais;

    public StockIntelectual(UUID id, String nome, Integer quantidade, LocalDate createdAt, LocalDate lastUpdated, 
    List<ProdutoIntelectual> produtoIntelectuais){
        super(id, nome, quantidade, createdAt, lastUpdated);
        this.produtoIntelectuais = produtoIntelectuais;
    }

}
