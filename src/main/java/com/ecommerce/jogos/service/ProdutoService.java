package com.ecommerce.jogos.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ecommerce.jogos.enums.OrdemEnum;
import com.ecommerce.jogos.model.Produto;
import com.ecommerce.jogos.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> findAll(OrdemEnum ordem) {
		
		Sort sortBy;
		
		if(ordem.equals(OrdemEnum.PRECO)) {
			
			sortBy = Sort.by(Sort.Direction.ASC, "price");
					
		}else if(ordem.equals(OrdemEnum.SCORE)){
			
			sortBy = Sort.by(Sort.Direction.DESC, "score");
			
		} else {
			
			sortBy = Sort.by(Sort.Direction.ASC, "name");
			
		} 
		
		return produtoRepository.findAll(sortBy);
	}

	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

	public Produto findById(Long idProduto) throws Exception {

		Optional<Produto> prod = produtoRepository.findById(idProduto);
		if (prod.isPresent()) {
			return prod.get();
		}
		return null;
	}

	public Produto createProd (Produto prod) {
		return produtoRepository.save(prod);
	}

	public Long createProdL (Produto prod) {
		return produtoRepository.save(prod).getId();
	}
}
