package com.ecommerce.jogos.response;

import java.util.ArrayList;
import java.util.List;

import com.ecommerce.jogos.api.ProdutoResource;
import com.ecommerce.jogos.model.Produto;

public class ProdutoResponse {

	private Long id;

	private String name;

	private Double price;

	private Integer score;

	private String image;

	public ProdutoResponse() {
	}

	public ProdutoResponse(Long id, String name, Double price, Integer score, String image) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.score = score;
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "ProdutoResponse [id=" + id + ", name=" + name + ", price=" + price + ", score=" + score + ", image="
				+ image + "]";
	}

	public static List<ProdutoResponse> converter(List<Produto> produtos) {
		List<ProdutoResponse> response = new ArrayList<ProdutoResponse>();
		response.forEach(p-> {
			response.add(new ProdutoResponse(p.getId(),p.getName(),p.getPrice(),p.getScore(),p.getImage()));
		});
		return response;
	}

	public static ProdutoResponse convertToProd(Produto uniqueProduct) throws Exception {

		if (uniqueProduct != null) {
			ProdutoResponse product = new ProdutoResponse(uniqueProduct.getId(), uniqueProduct.getName(), uniqueProduct.getPrice(), uniqueProduct.getScore(), uniqueProduct.getImage());
			return product;
		} else {
			throw new Exception("Não foi encontrado nenhum produto");
		}


	}


}


