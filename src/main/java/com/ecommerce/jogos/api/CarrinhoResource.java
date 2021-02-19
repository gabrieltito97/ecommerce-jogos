package com.ecommerce.jogos.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.jogos.response.CarrinhoResponse;
import com.ecommerce.jogos.response.CheckoutResponse;
import com.ecommerce.jogos.service.CarrinhoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/carrinho")
@Api(value = "API de operações do carrinho")
public class CarrinhoResource {

	@Autowired
	private CarrinhoService carrinhoService;
	
	@ApiOperation(value = "Busca carrinho")
	@GetMapping
	public List<CarrinhoResponse> get(@RequestHeader(value="token") String token){
		return CarrinhoResponse.converter(carrinhoService.findAll(token));
	}
	
	@ApiOperation(value = "Adiciona ou atualiza um carrinho")
	@PutMapping("/{idProduto}/{quantity}")
	public void atualizarProdutoCarrinho(@PathVariable Long idProduto, @PathVariable Integer quantity, @RequestHeader(value="token") String token) throws Exception {
		carrinhoService.atualizarProdutoCarrinho(idProduto, quantity, token);
	}
	
	@ApiOperation(value = "Deleta produto do carrinho")
	@DeleteMapping("/{idProduto}")
	public void deletarProdutoCarrinho(@PathVariable Long idProduto, @RequestHeader(value="token") String token) throws Exception {
		carrinhoService.deletarProdutoCarrinho(idProduto, token);
	}
	
	@ApiOperation(value = "Faz o checkout do carrinho")
	@PostMapping("/checkout")
	public CheckoutResponse checkout(@RequestHeader(value="token") String token) throws Exception {
		return CheckoutResponse.converter(carrinhoService.checkoutCarrinho(token));
	}
	
}
