package com.ecommerce.jogos.response;

import java.util.List;

import com.ecommerce.jogos.model.Carrinho;

public class CheckoutResponse {

	private Double subtotal = 0.0D;
	
	private Double frete = 0.0D;
	
	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getFrete() {
		return frete;
	}

	public void setFrete(Double frete) {
		this.frete = frete;
	}

	public Double getTotal() {
		return subtotal + frete;
	}
	
	public static CheckoutResponse converter(List<Carrinho> carrinhos) {
		CheckoutResponse checkoutResponse = new CheckoutResponse();
	
		for (Carrinho carrinho : carrinhos) {
			
			//subtotal
			Double subtotalProduto = carrinho.getProduto().getPrice() * carrinho.getQuantity();
			Double subtotalSomado = checkoutResponse.getSubtotal() + subtotalProduto;
			checkoutResponse.setSubtotal(subtotalSomado);
			
			//frete
			Double freteProduto = Double.valueOf(carrinho.getQuantity() * 10);
			Double freteSomado = checkoutResponse.getFrete() + freteProduto;
			checkoutResponse.setFrete(freteSomado);
			
		}
		
		if(checkoutResponse.getSubtotal() > 250D) {
			checkoutResponse.setFrete(0.0D);
		}
		
		return checkoutResponse;
	}

}
