package com.group05.abstractbusiness.model.Business;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private UUID ID;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "status")
    private Boolean status;
    
    @Column(name = "custo")
    private Double custo;
    
    @Column(name = "preco")
    private Double preco;
    
    @Column(name = "marca")                                     // Define o nome da coluna como "marca" no banco de dados
    private String brand;
    
    @Column(name = "categoria")                                 // Define o nome da coluna como "categoria" no banco de dados
    private String category;
    
    @Column(name = "sub_categoria")                             // Define o nome da coluna como "sub_categoria" no banco de dados
    private String subCategory;
    
    @Column(name = "imagem")                                
    private String image;
    
    @Column(name = "criado_em")
    private LocalDateTime createdAt;                            // Define o nome da coluna como "criado_em" no banco de dados
        
    @Column(name = "atualizado_em")                             // Define o nome da coluna como "atualizado_em" no banco de dados
    private LocalDateTime updatedAt;    
        
    @Column(name = "deletado_em")                               // Define o nome da coluna como "deletado_em" no banco de dados
    private LocalDateTime deletedAt;

    public Produto(UUID iD, String nome, String descricao, Boolean status, Double custo, Double preco, String brand,
            String category, String subCategory, String image, LocalDateTime createdAt, LocalDateTime updatedAt,
            LocalDateTime deletedAt) {
        this.ID = iD;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.custo = custo;
        this.preco = preco;
        this.brand = brand;
        this.category = category;
        this.subCategory = subCategory;
        this.image = image;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public Produto(){}
    
}
