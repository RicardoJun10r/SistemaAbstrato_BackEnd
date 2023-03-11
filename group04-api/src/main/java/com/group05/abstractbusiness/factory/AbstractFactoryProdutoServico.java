package com.group05.abstractbusiness.factory;

import com.group05.abstractbusiness.model.Produto;
import com.group05.abstractbusiness.model.Servico;

public interface AbstractFactoryProdutoServico{

    public Produto criarProduto();
    public Servico criarServico();

}
