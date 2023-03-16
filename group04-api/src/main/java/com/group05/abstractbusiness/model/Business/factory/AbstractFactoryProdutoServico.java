package com.group05.abstractbusiness.model.Business.factory;

import org.springframework.stereotype.Component;

import com.group05.abstractbusiness.model.Business.Produto;
import com.group05.abstractbusiness.model.Business.Servico;

@Component
public interface AbstractFactoryProdutoServico{

    public Produto criarProduto();
    public Servico criarServico();

}
