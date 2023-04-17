package com.group05.abstractbusiness.modules.model.Business.factory;

import org.springframework.stereotype.Component;

import com.group05.abstractbusiness.modules.model.Business.Produto;

@Component
public interface AbstractFactoryProduto{

    public Produto criarFisco();

    public Produto criarDigital();
    
    public Produto criarIntelectual();

}
