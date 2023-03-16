package com.group05.abstractbusiness.model.Business;

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

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "tipo")
    private final String TIPO = "FISI";

    public ServicoFisico(ServicoFisico product){
        super(product.getID(), product.getNome(), product.getDescricao(), product.getStatus(), product.getCusto(), product.getPreco());
        this.quantidade = product.quantidade;
        this.endereco = product.endereco;
    }

    public ServicoFisico(UUID iD, String nome, String descricao, Boolean status,
            Double custo, Double preco, Integer quantidade, String endereco) {
        super(iD, nome, descricao, status, custo, preco);
        this.quantidade = quantidade;
        this.endereco = endereco;
    }

    public ServicoFisico(){}
}
