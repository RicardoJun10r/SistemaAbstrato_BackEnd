package com.group05.abstractbusiness.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "fisicoSer_tb")
@Getter
@Setter
public class ServicoFisico extends Servico {
    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "tipo")
    private final String TIPO = "FISI";

    public ServicoFisico(ServicoFisico product){
        super(product.getID(), product.getNome(), product.getDescricao(), product.getStatus(), product.getCusto(), product.getPreco());
        this.quantidade = product.quantidade;
    }

    public ServicoFisico(UUID iD, String nome, String descricao, Boolean status,
            Double custo, Double preco, Integer quantidade) {
        super(iD, nome, descricao, status, custo, preco);
        this.quantidade = quantidade;
    }

    public ServicoFisico(){}
}
