package com.group05.abstractbusiness.modules.model.Stock;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.group05.abstractbusiness.modules.model.Business.ProdutoDigital;
import com.group05.abstractbusiness.modules.model.Person.Users.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Table(name = "stock_digi_tb")
@NoArgsConstructor
public class StockDigital extends StockProducts {

    @JsonBackReference
    @ManyToOne
    private User user;
    
    @JsonManagedReference
    @OneToMany(targetEntity = ProdutoDigital.class, mappedBy = "stockDigital", cascade = CascadeType.ALL)
    private List<ProdutoDigital> produtosDigitais;

    public StockDigital(UUID id, String nome, Integer quantidade, LocalDate createdAt, LocalDate lastUpdated, 
    List<ProdutoDigital> produtosDigitais){
        super(id, nome, quantidade, createdAt, lastUpdated);
        this.produtosDigitais = produtosDigitais;
    }
    
}
