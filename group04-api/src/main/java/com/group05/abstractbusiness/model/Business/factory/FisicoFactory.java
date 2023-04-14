package com.group05.abstractbusiness.model.Business.factory;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.group05.abstractbusiness.model.Business.Produto;
import com.group05.abstractbusiness.model.Business.ProdutoFisico;
import com.group05.abstractbusiness.model.Business.Servico;
import com.group05.abstractbusiness.model.Business.ServicoFisico;

import lombok.Getter;
import lombok.Setter;

/**
 *  FACTORY de produtos FISICO
 */
@Component
@Getter
@Setter
public class FisicoFactory implements AbstractFactoryProdutoServico {

    private UUID ID;

    private String nome;

    private String descricao;

    private Boolean status;

    private Double custo;

    private Double preco;

    private Integer quantidade;

    private String endereco;

    public FisicoFactory(){}

    // CONSTRUTOR DE PRODUTO FISICO
    public FisicoFactory(UUID iD, String nome, String descricao, Boolean status, Double custo, Double preco,
            Integer quantidade) {
        this.ID = iD;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.custo = custo;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // CONSTRUTOR DE SERVICO FISICO
    public FisicoFactory(UUID iD, String nome, String descricao, Boolean status, Double custo, Double preco,
            Integer quantidade, String endereco) {
        this.ID = iD;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.custo = custo;
        this.preco = preco;
        this.quantidade = quantidade;
        this.endereco = endereco;
    }

    @Override
    public Produto criarProduto() {

        return new ProdutoFisico(
            this.ID, this.nome, this.descricao,
            this.status, this.custo, this.preco,
            this.quantidade);

    }

    @Override
    public Servico criarServico() {

        return new ServicoFisico(
            this.ID, this.nome, this.descricao,
            this.status, this.custo, this.preco,
            this.quantidade, this.endereco);
    }
    
}