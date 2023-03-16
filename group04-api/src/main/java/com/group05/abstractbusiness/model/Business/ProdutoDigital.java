package com.group05.abstractbusiness.model.Business;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "digitalPd_tb")
public class ProdutoDigital extends Produto {

    @Column(name = "autor")
    private String autor;

    @Column(name = "copyright")
    private Boolean copyright;

    @Column(name = "tipo")
    private final String TIPO = "DIGI";

    public ProdutoDigital(ProdutoDigital product){
        super(product.getID(), product.getNome(), product.getDescricao(), product.getStatus(), product.getCusto(), product.getPreco());
        this.autor = product.autor;
        this.copyright = product.copyright;
    }

    public ProdutoDigital(UUID iD, String nome, String descricao, Boolean status,
            Double custo, Double preco, String autor, Boolean copyright) {
        super(iD, nome, descricao, status, custo, preco);
        this.autor = autor;
        this.copyright = copyright;
    }

    public ProdutoDigital(){}
    
}
