package org.openjfx.farmacia.tests;

import org.junit.Test;
import org.openjfx.farmacia.produto.InvalidProductException;
import org.openjfx.farmacia.produto.NegativeAmountException;
import org.openjfx.farmacia.produto.NegativePriceException;

import static org.junit.Assert.assertTrue;
import static org.openjfx.farmacia.controller.NovoProdutoController.validaProduto;

public class NovoProdutoControllerTest {
	@Test
	public void validaProdutoTest() throws InvalidProductException {
		try {
			assertTrue(validaProduto(-200.00, 20));
			assertTrue(validaProduto(200.00, -20));
			assertTrue(validaProduto(200.00, 20));
		} catch (NegativePriceException exception) {
			throw new InvalidProductException(exception);
		} catch (NegativeAmountException exception) {
			throw new InvalidProductException(exception);
		}

	}
}
