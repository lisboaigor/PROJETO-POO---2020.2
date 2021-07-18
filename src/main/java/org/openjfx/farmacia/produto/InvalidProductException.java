package org.openjfx.farmacia.produto;

public class InvalidProductException extends Exception {
	public InvalidProductException(String message) {
		super(message);
	}
	
	public InvalidProductException(Throwable cause) {
		super(cause);
	}
	
	public InvalidProductException(String message, Throwable cause) {
		super(message, cause);
	}
}
