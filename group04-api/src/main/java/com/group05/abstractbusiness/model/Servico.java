package com.group05.abstractbusiness.model;

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
public abstract class Servico {
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

    public Servico(UUID ID, String nome, String descricao, Boolean status, Double custo,
            Double preco) {
        this.ID = ID;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.custo = custo;
        this.preco = preco;
    }

    public Servico(){}
}
