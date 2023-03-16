package com.group05.abstractbusiness.model.Business.factory;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.group05.abstractbusiness.model.Business.Produto;
import com.group05.abstractbusiness.model.Business.ProdutoDigital;
import com.group05.abstractbusiness.model.Business.Servico;
import com.group05.abstractbusiness.model.Business.ServicoDigital;

import lombok.Getter;
import lombok.Setter;

/**
 *  FACTORY de produtos DIGITAIS
 */
@Component
@Getter
@Setter
public class DigitalFactory implements AbstractFactoryProdutoServico {

    private UUID ID;

    private String nome;

    private String descricao;

    private Boolean status;

    private Double custo;

    private Double preco;

    private String autor;
    
    private Boolean copyright;

    public DigitalFactory(){}

    // CONSTRUTOR DE SERVICO DIGITAL
    public DigitalFactory(UUID iD, String nome, String descricao, Boolean status, Double custo, Double preco,
            String autor) {
        this.ID = iD;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.custo = custo;
        this.preco = preco;
        this.autor = autor;
    }

    // CONSTRUTOR DE PRODUTO DIGITAL
    public DigitalFactory(UUID iD, String nome, String descricao, Boolean status, Double custo, Double preco,
            String autor, Boolean copyright) {
        this.ID = iD;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.custo = custo;
        this.preco = preco;
        this.autor = autor;
        this.copyright = copyright;
    }

    @Override
    public Produto criarProduto() {
        return new ProdutoDigital(  
            this.ID, this.nome, this.descricao, 
            this.status, this.custo, this.preco, 
            this.autor, this.copyright);
    }

    @Override
    public Servico criarServico() {
        return new ServicoDigital(
            this.ID, this.nome, this.descricao, 
            this.status, this.custo, this.preco, 
            this.autor);
    }
    
}
