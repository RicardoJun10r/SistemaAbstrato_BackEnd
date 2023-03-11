package com.group05.abstractbusiness.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "digitalSer_tb")
@Getter
@Setter
public class ServicoDigital extends Servico {
    @Column(name = "autor")
    private String autor;

    @Column(name = "tipo")
    private final String TIPO = "DIGI";

    public ServicoDigital(ServicoDigital product){
        super(product.getID(), product.getNome(), product.getDescricao(), product.getStatus(), product.getCusto(), product.getPreco());
        this.autor = product.autor;
    }

    public ServicoDigital(UUID iD, String nome, String descricao, Boolean status,
            Double custo, Double preco, String autor) {
        super(iD, nome, descricao, status, custo, preco);
        this.autor = autor;
    }

    public ServicoDigital(){}
}
