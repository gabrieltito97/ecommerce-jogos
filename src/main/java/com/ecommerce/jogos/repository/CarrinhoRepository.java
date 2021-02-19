package com.ecommerce.jogos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.jogos.model.Carrinho;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Long>{

	List<Carrinho> findByToken(String token);

	Carrinho findByProdutoIdAndToken(Long idProduto, String token);

}
