package com.ecommerce.jogos.request;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

@Validated
public class ProdRequest {

    @NotNull
    @Length(min = 3 , max = 25)
    private String name;

    @DecimalMax("200") @DecimalMin("0.0")
    private Double price;

    @Min(value = 0)
    @Max(value = 10)
    private Integer score;

    @NotNull
    @Length(min = 3 , max = 25)
    private String image;

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
}
