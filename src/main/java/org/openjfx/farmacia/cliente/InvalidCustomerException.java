package org.openjfx.farmacia.cliente;

public class InvalidCustomerException extends Exception {
	public InvalidCustomerException(String message) {
		super(message);
	}
	
	public InvalidCustomerException(Throwable cause) {
		super(cause);
	}
	
	public InvalidCustomerException(String message, Throwable cause) {
		super(message, cause);
	}
}