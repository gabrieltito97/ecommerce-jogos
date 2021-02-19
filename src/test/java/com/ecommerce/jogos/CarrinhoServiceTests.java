package com.ecommerce.jogos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.jogos.response.CheckoutResponse;
import com.ecommerce.jogos.service.CarrinhoService;

@SpringBootTest
class CarrinhoServiceTests {

	@Autowired
	private CarrinhoService carrinhoService;
	
	@Test
	void testeBuscarCarrinhoVazio() {
		assertEquals(0, carrinhoService.findAll("abc").size());
	}

	@Test
	void testeInserirProdutoCarrinho() throws Exception {
		carrinhoService.atualizarProdutoCarrinho(1L, 3, "abcd");
		assertEquals(1, carrinhoService.findAll("abcd").size());
	}

	@Test
	void testeInserirProdutoNaoExisteCarrinho() throws Exception {
		 try {
			carrinhoService.atualizarProdutoCarrinho(50L, 3, "abcd");
		} catch (Exception e) {
			return;
		}
		
		throw new Exception();
	}

	@Test
	void testeDeletarProdutoCarrinho() throws Exception {
		carrinhoService.atualizarProdutoCarrinho(1L, 3, "aaa");
		carrinhoService.deletarProdutoCarrinho(1L, "aaa");
		assertEquals(0, carrinhoService.findAll("aaa").size());
	}

	@Test
	void testeDeletarProdutoQueNaoExisteCarrinho() throws Exception {
		 try {
			 carrinhoService.deletarProdutoCarrinho(6L, "bbb");
		} catch (Exception e) {
			return;
		}
		
		throw new Exception();
	}

	@Test
	void testeCheckoutCarrinho() throws Exception {
		carrinhoService.atualizarProdutoCarrinho(1L, 3, "ccc");
		carrinhoService.checkoutCarrinho("ccc");
	}

	@Test
	void testeCheckoutCarrinhoNaoExiste() throws Exception {
		 try {
			 carrinhoService.checkoutCarrinho("ddd");
		} catch (Exception e) {
			return;
		}
		
		throw new Exception();
	}
	
	@Test
	void testeCheckoutCarrinhoComFrete() throws Exception {
		carrinhoService.atualizarProdutoCarrinho(2L, 1, "fff");
		carrinhoService.atualizarProdutoCarrinho(3L, 1, "fff");
		CheckoutResponse checkout = CheckoutResponse.converter(carrinhoService.checkoutCarrinho("fff"));
		assertEquals(169.49D, checkout.getSubtotal());
		assertEquals(189.49D, checkout.getTotal());
		assertNotEquals(checkout.getTotal(), checkout.getSubtotal());
		assertEquals(20.0D, checkout.getFrete());
	}

	@Test
	void testeCheckoutCarrinhoSemFrete() throws Exception {
		carrinhoService.atualizarProdutoCarrinho(2L, 1, "ggg");
		carrinhoService.atualizarProdutoCarrinho(3L, 1, "ggg");
		carrinhoService.atualizarProdutoCarrinho(4L, 1, "ggg");
		carrinhoService.atualizarProdutoCarrinho(5L, 1, "ggg");
		CheckoutResponse checkout = CheckoutResponse.converter(carrinhoService.checkoutCarrinho("ggg"));
		assertEquals(489.47D, checkout.getSubtotal());
		assertEquals(checkout.getTotal(), checkout.getSubtotal());
		assertEquals(0.0D, checkout.getFrete());
	}
	
}
