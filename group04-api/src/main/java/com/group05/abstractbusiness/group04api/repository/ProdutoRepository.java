package com.group05.abstractbusiness.group04api.repository;

import org.springframework.stereotype.Repository;

import com.group05.abstractbusiness.group04api.model.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    public Produto adicionar(Produto produto);
}
