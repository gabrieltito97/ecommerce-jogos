package com.ecommerce.jogos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.jogos.response.CheckoutResponse;

@SpringBootTest
public class CheckoutResponseTest {

	
	@Test
	void testaCalculoTotalCheckout() {
		CheckoutResponse checkoutResponse = new CheckoutResponse();
		checkoutResponse.setSubtotal(550.00);
		checkoutResponse.setFrete(50.00);
		
		assertEquals(600.00,checkoutResponse.getTotal());
		
	}
}
