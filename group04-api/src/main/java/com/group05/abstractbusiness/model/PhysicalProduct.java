package com.group05.abstractbusiness.model;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "physicalPd_tb")
@Getter
@Setter
public class PhysicalProduct extends Produto {

    @Column(name = "quantidade")
    private Integer quantidade;

    public PhysicalProduct(PhysicalProduct product){
        super(product.getID(), product.getNome(), product.getDescricao(), product.getStatus(), product.getCusto(), product.getPreco());
        this.quantidade = product.quantidade;
    }

    public PhysicalProduct(UUID iD, String nome, String descricao, Boolean status,
            Double custo, Double preco, Integer quantidade) {
        super(iD, nome, descricao, status, custo, preco);
        this.quantidade = quantidade;
    }

}