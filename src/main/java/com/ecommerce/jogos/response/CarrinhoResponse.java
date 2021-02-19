package com.ecommerce.jogos.response;

import java.util.ArrayList;
import java.util.List;

import com.ecommerce.jogos.model.Carrinho;

public class CarrinhoResponse {

	private Long id;
	
	private Integer quantity;
	
	private String produto;
	
	public CarrinhoResponse() {
	}

	public CarrinhoResponse(Long id, Integer quantity, String produto) {
		this.id = id;
		this.quantity = quantity;
		this.produto = produto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "CarrinhoResponse [id=" + id + ", quantity=" + quantity + ", produto=" + produto +"]";
	}

	public static List<CarrinhoResponse> converter(List<Carrinho> carrinhos) {
		List<CarrinhoResponse> response = new ArrayList<CarrinhoResponse>();
		for (Carrinho carrinho : carrinhos) {
			response.add(new CarrinhoResponse(carrinho.getId(), carrinho.getQuantity(), carrinho.getProduto().getName()));
		}
		return response;
	}

}
