package com.group05.abstractbusiness.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.group05.abstractbusiness.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
