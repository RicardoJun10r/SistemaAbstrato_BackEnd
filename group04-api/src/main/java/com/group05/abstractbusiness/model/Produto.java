package com.group05.abstractbusiness.model;

import java.util.UUID;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class Produto extends Mercadoria {

    public Produto(UUID ID, String nome, String descricao, Boolean status, Double custo,
            Double preco) {
        super(ID, nome, descricao, status, custo, preco);
    }

    public Produto(){}
}
