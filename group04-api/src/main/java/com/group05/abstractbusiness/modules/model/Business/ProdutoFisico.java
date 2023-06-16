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
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "fisicoPd_tb")
@Getter
@Setter
@Valid
@NoArgsConstructor
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

    public ProdutoFisico(UUID ID, String name, String description, Boolean status, Double cost, Double price,
            String brand, String category, String subCategory, String image, LocalDate createdAt, LocalDate updatedAt,
            LocalDate deletedAt, Float weight, Float height, Float width, Integer quantity,
            Supplier supplier){
        super(ID, name, description, status, cost, price, brand, category, subCategory, image, createdAt, updatedAt,
                deletedAt);
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.quantity = quantity;
        this.supplier = supplier;
    }
    
}