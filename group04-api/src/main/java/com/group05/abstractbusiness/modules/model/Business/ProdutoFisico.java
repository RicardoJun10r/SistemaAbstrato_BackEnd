package com.group05.abstractbusiness.modules.model.Business;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.group05.abstractbusiness.modules.model.Person.Supplier;
import com.group05.abstractbusiness.modules.model.Stock.StockFisico;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "fisicoPd_tb")
@Getter
@Setter
@Valid
public class ProdutoFisico extends Produto {

    @Column(name = "weight")
    private Float weight;

    @Column(name = "height")
    private Float height;

    @Column(name = "width")
    private Float width;

    @Column(name = "quantidade")
    private Integer quantity;

    @JsonBackReference
    @ManyToOne
    private StockFisico stock;

    @OneToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    public ProdutoFisico(UUID iD, Long codigo, String nome, String descricao, Boolean status, Double custo, Double preco,
            String brand, String category, String subCategory, String image, LocalDate createdAt,
            LocalDate updatedAt, LocalDate deletedAt, Float weight, Float height, Float width, Integer quantidade, Supplier supplier) {
        super(iD, codigo, nome, descricao, status, custo, preco, brand, category, subCategory, image, createdAt, updatedAt,
                deletedAt);
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.quantity = quantidade;
        this.supplier = supplier;
    }

    public ProdutoFisico(Float weight, Float height, Float width, Integer quantidade) {
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.quantity = quantidade;
    }

    public ProdutoFisico(){}
    
}