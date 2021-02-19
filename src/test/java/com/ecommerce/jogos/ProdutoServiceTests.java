package com.ecommerce.jogos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.jogos.enums.OrdemEnum;
import com.ecommerce.jogos.service.ProdutoService;

@SpringBootTest
class ProdutoServiceTests {

	@Autowired
	private ProdutoService produtoService;
	
	@Test
	void testeQuantidadeDeProdutos() {
		assertEquals(9, produtoService.findAll().size());
	}
	
	@Test
	void testeProdutoPorOrdemPreco() {
		
		assertEquals(49.99, produtoService.findAll(OrdemEnum.PRECO).get(0).getPrice());
		assertEquals(249.99, produtoService.findAll(OrdemEnum.PRECO).get(8).getPrice());
	}
	
	@Test
	void testeProdutoPorOrdemScore() {
		
		assertEquals(400, produtoService.findAll(OrdemEnum.SCORE).get(0).getScore());
		assertEquals(50, produtoService.findAll(OrdemEnum.SCORE).get(8).getScore());
	}
	
	@Test
	void testeProdutoPorOrdemAlfabetica() {
		
		assertEquals("Call Of Duty Infinite Warfare", produtoService.findAll(OrdemEnum.ALFABETICA).get(0).getName());
		assertEquals("The Witcher III Wild Hunt", produtoService.findAll(OrdemEnum.ALFABETICA).get(8).getName());
	}

}
