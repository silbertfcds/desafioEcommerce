package com.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
