package org.openjfx.farmacia.produto;

@SuppressWarnings("serial")
public class NegativeAmountException extends InvalidProductException {
	public NegativeAmountException(String message) {
		super(message);
	}
	
	public NegativeAmountException(Throwable cause) {
		super(cause);
	}
	
	public NegativeAmountException(String message, Throwable cause) {
		super(message, cause);
	}
}
