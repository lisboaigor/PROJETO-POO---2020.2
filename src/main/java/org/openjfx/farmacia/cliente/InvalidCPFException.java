package org.openjfx.farmacia.cliente;

@SuppressWarnings("serial")
public class InvalidCPFException extends InvalidCustomerException{
	public InvalidCPFException(String message) {
		super(message);
	}
}
