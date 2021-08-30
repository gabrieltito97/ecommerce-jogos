package com.ecommerce.jogos.api;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ecommerce.jogos.model.Produto;
import com.ecommerce.jogos.request.ProdRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.jogos.enums.OrdemEnum;
import com.ecommerce.jogos.response.ProdutoResponse;
import com.ecommerce.jogos.service.ProdutoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;

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

	@GetMapping("/{id}")
	public ProdutoResponse getProdById (@PathVariable Long id) throws Exception {
		return ProdutoResponse.convertToProd(produtoService.findById(id));
	}

	@PostMapping("/addProd")
	public ResponseEntity<Produto> addProd (@RequestBody @Valid ProdRequest prodRequest) {
		Produto prod = new Produto();
		BeanUtils.copyProperties(prodRequest,prod);
		produtoService.createProd(prod);
		return new ResponseEntity<>(prod, HttpStatus.CREATED);
	}

	@PostMapping("/addProdL")
	public Long addProdL (@RequestBody @Valid ProdRequest prodRequest) {
		Produto prod = new Produto();
		BeanUtils.copyProperties(prodRequest, prod);
		return produtoService.createProdL(prod);

	}

}
