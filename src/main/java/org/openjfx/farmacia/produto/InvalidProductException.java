package org.openjfx.farmacia.produto;

@SuppressWarnings("serial")
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
