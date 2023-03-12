package com.group05.abstractbusiness.factory;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.group05.abstractbusiness.model.Produto;
import com.group05.abstractbusiness.model.ProdutoIntelectual;
import com.group05.abstractbusiness.model.Servico;
import com.group05.abstractbusiness.model.ServicoIntelectual;

/**
 *  FACTORY de produtos INTELECTUAIS
 */
@Component
public class IntelectualFactory implements AbstractFactoryProdutoServico {

    private UUID ID; 
    
    private String nome; 
    
    private String descricao;
    
    private Boolean status;
    
    private Double custo; 
    
    private Double preco; 
    
    private String autor;

    private Boolean copyright;

    // CONSTRUTOR DE SERVICO FISICO
    public IntelectualFactory(UUID iD, String nome, String descricao, Boolean status, Double custo, Double preco,
            String autor) {
        this.ID = iD;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.custo = custo;
        this.preco = preco;
        this.autor = autor;
    }

    // CONSTRUTOR DE PRODUTO FISICO
    public IntelectualFactory(UUID iD, String nome, String descricao, Boolean status, Double custo, Double preco,
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

        return new ProdutoIntelectual(
            this.ID, this.nome, this.descricao,
            this.status, this.custo, this.preco,
            this.autor, this.copyright);

    }

    @Override
    public Servico criarServico() {

        return new ServicoIntelectual(
            this.ID, this.nome, this.descricao,
            this.status, this.custo, this.preco,
            this.autor);

    }
    
}
