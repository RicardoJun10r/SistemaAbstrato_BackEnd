package com.group05.abstractbusiness.factory;

import org.springframework.stereotype.Component;

import com.group05.abstractbusiness.model.Produto;
import com.group05.abstractbusiness.model.Servico;

@Component
public interface AbstractFactoryProdutoServico{

    public Produto criarProduto();
    public Servico criarServico();

}
