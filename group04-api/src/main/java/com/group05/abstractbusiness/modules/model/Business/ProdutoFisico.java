package com.group05.abstractbusiness.modules.model.Business;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.group05.abstractbusiness.model.Stock.StockProducts;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

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

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "tipo")
    private final String TIPO = "FISI";

    @JsonBackReference
    @ManyToOne
    private StockProducts stock;

    public ProdutoFisico(UUID iD, String nome, String descricao, Boolean status, Double custo, Double preco,
            String brand, String category, String subCategory, String image, LocalDate createdAt,
            LocalDate updatedAt, LocalDate deletedAt, Float weight, Float height, Float width,
            String imageUrl) {
        super(iD, nome, descricao, status, custo, preco, brand, category, subCategory, image, createdAt, updatedAt,
                deletedAt);
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.imageUrl = imageUrl;
    }

    public ProdutoFisico(Float weight, Float height, Float width, String imageUrl) {
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.imageUrl = imageUrl;
    }

    public ProdutoFisico(){}
    
}