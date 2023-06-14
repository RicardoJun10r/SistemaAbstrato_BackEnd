package com.group05.abstractbusiness.modules.model.Business;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@Valid
public abstract class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private UUID ID;

    @Column(name = "codigo", unique = true, nullable = false)
    private Long code;
    
    @Column(name = "nome")
    private String name;
    
    @Column(name = "descricao")
    private String description;
    
    @Column(name = "status")
    private Boolean status;
    
    @Column(name = "custo")
    private Double cost;
    
    @Column(name = "preco")
    private Double price;
    
    @Column(name = "marca")
    private String brand;
    
    @Column(name = "categoria")
    private String category;
    
    @Column(name = "sub_categoria")
    private String subCategory;
    
    @Column(name = "imagem")
    private String image;
    
    @Column(name = "criado_em")
    private LocalDate createdAt;                                
        
    @Column(name = "atualizado_em")
    private LocalDate updatedAt;    
        
    @Column(name = "deletado_em")
    private LocalDate deletedAt;

    public Produto(UUID iD, Long codigo, String nome, String descricao, Boolean status, Double custo, Double preco, String brand,
            String category, String subCategory, String image, LocalDate createdAt, LocalDate updatedAt,
            LocalDate deletedAt) {
        this.ID = iD;
        this.code = codigo;
        this.name = nome;
        this.description = descricao;
        this.status = status;
        this.cost = custo;
        this.price = preco;
        this.brand = brand;
        this.category = category;
        this.subCategory = subCategory;
        this.image = image;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public Produto(){}

    @PrePersist
    public void onCreate(){
        this.createdAt = LocalDate.now();
    }
    
}
