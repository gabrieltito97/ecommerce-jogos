package com.ecommerce.jogos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.jogos.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
