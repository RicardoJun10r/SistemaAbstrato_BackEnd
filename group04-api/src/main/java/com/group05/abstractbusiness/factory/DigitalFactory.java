package com.group05.abstractbusiness.factory;

import com.group05.abstractbusiness.model.Produto;
import com.group05.abstractbusiness.model.ProdutoDigital;
import com.group05.abstractbusiness.model.Servico;
import com.group05.abstractbusiness.model.ServicoDigital;

public class DigitalFactory implements AbstractFactoryProdutoServico {

    @Override
    public Produto criarProduto() {
        return new ProdutoDigital();
    }

    @Override
    public Servico criarServico() {
        return new ServicoDigital();
    }
    
}
