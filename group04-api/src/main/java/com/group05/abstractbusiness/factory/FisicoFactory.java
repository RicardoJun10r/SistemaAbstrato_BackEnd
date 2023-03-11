package com.group05.abstractbusiness.factory;

import com.group05.abstractbusiness.model.Produto;
import com.group05.abstractbusiness.model.ProdutoFisico;
import com.group05.abstractbusiness.model.Servico;
import com.group05.abstractbusiness.model.ServicoFisico;

public class FisicoFactory implements AbstractFactoryProdutoServico {

    @Override
    public Produto criarProduto() {
        return new ProdutoFisico();
    }

    @Override
    public Servico criarServico() {
        return new ServicoFisico();
    }
    
}
