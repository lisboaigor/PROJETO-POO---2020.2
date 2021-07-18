package org.openjfx.farmacia.tests;

import org.junit.Test;
import org.openjfx.farmacia.cliente.InvalidCPFException;
import org.openjfx.farmacia.controller.NovoClienteController;

import static org.junit.Assert.assertTrue;

public class NovoClienteControllerTest {
	@Test
	public void validaCPFTest() {
		try {
			assertTrue(NovoClienteController.validarCPF("12345678912"));
			assertTrue(NovoClienteController.validarCPF("1234567891a"));
			assertTrue(NovoClienteController.validarCPF("1234567891A"));
			assertTrue(NovoClienteController.validarCPF("1234567891"));
		} catch (InvalidCPFException exception) {
			exception.printStackTrace();
		}
	}
}
