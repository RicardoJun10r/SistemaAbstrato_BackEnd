package com.group05.abstractbusiness.modules.model.Stock;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.group05.abstractbusiness.modules.model.Business.ProdutoFisico;
import com.group05.abstractbusiness.modules.model.Person.Users.User;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
@Table(name = "stock_fisi_tb")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class StockFisico extends StockProducts {

    @JsonBackReference
    @ManyToOne
    private User user;

    @Column(name = "localizacao")
    private String address;
    
    @JsonManagedReference
    @OneToMany(targetEntity = ProdutoFisico.class, mappedBy = "stockFisico", cascade = CascadeType.ALL)
    private List<ProdutoFisico> produtosFisicos;

    public StockFisico(UUID id, String nome, Integer quantidade, LocalDate createAt, LocalDate lastUpdated, String localizacao,
            List<ProdutoFisico> produtos){
        super(id, nome, quantidade, createAt, lastUpdated);
        this.address = localizacao;
        this.produtosFisicos = produtos;
    }

}
