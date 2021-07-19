package org.openjfx.farmacia.produto;

@SuppressWarnings("serial")
public class NegativePriceException extends InvalidProductException {
	public NegativePriceException(String message) {
		super(message);
	}
	
	public NegativePriceException(Throwable cause) {
		super(cause);
	}
	
	public NegativePriceException(String message, Throwable cause) {
		super(message, cause);
	}
}
