package com.ecommerce.jogos.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.jogos.enums.OrdemEnum;
import com.ecommerce.jogos.response.ProdutoResponse;
import com.ecommerce.jogos.service.ProdutoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/produto")
@Api(value = "API para listar os produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;
	
	@ApiOperation(value = "Retorna lista de jogos ordenado (por preço,score ou ordem alfabética")
	@GetMapping("/order/{ordem}")
	public List<ProdutoResponse> get(@PathVariable OrdemEnum ordem){
		return ProdutoResponse.converter(produtoService.findAll(ordem));
	}

	@ApiOperation(value = "Retorna lista de todos os jogos da loja")
	@GetMapping("/")
	public List<ProdutoResponse> get(){
		return ProdutoResponse.converter(produtoService.findAll());
	}
	
}
