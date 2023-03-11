package com.group05.abstractbusiness.factory;

import com.group05.abstractbusiness.model.Produto;
import com.group05.abstractbusiness.model.ProdutoIntelectual;
import com.group05.abstractbusiness.model.Servico;
import com.group05.abstractbusiness.model.ServicoIntelectual;

public class IntelectualFactory implements AbstractFactoryProdutoServico {

    @Override
    public Produto criarProduto() {
        return new ProdutoIntelectual();
    }

    @Override
    public Servico criarServico() {
        return new ServicoIntelectual();
    }
    
}
