package com.ecommerce.jogos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.jogos.model.Carrinho;
import com.ecommerce.jogos.model.Produto;
import com.ecommerce.jogos.repository.CarrinhoRepository;

@Service
public class CarrinhoService {

	@Autowired
	private CarrinhoRepository carrinhoRepository;
	
	@Autowired
	private ProdutoService produtoService;

	public List<Carrinho> findAll(String token) {
		return carrinhoRepository.findByToken(token);
	}

	public void atualizarProdutoCarrinho(Long idProduto, Integer quantity, String token) throws Exception {
		Carrinho carrinho = this.carrinhoRepository.findByProdutoIdAndToken(idProduto, token);
		
		if(carrinho == null) {
			
			Optional<Produto> produto = produtoService.findById(idProduto);
			
			if(!produto.isPresent()) {
				throw new Exception("Produto não existe");
			}
			
			Carrinho carrinhoNovo = new Carrinho();
			carrinhoNovo.setProduto(produto.get());
			carrinhoNovo.setQuantity(quantity);
			carrinhoNovo.setToken(token);
			
			carrinhoRepository.save(carrinhoNovo);
			
		} else {
			
			carrinho.setQuantity(quantity);
			carrinhoRepository.save(carrinho);
			
		}
	}

	public void deletarProdutoCarrinho(Long idProduto, String token) throws Exception {
		Carrinho carrinho = this.carrinhoRepository.findByProdutoIdAndToken(idProduto, token);
		
		if(carrinho == null) {
			throw new Exception("Carrinho invalido");
		}
		
		carrinhoRepository.delete(carrinho);
		
	}

	public List<Carrinho> checkoutCarrinho(String token) throws Exception {
		List<Carrinho> carrinhos = carrinhoRepository.findByToken(token);
		
		if(carrinhos.isEmpty()) {
			throw new Exception("Carrinho invalido");
		}
		
		return carrinhos;
	}
	
}
