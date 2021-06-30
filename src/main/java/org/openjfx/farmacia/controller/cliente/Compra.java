package org.openjfx.farmacia.controller.cliente;

public class Compra {
	private final String CODIGO;
	private int quantidade;
	
	public Compra(String CODIGO, int quantidade) {
		this.CODIGO = CODIGO;
		setQuantidade(quantidade);
	}

	public String getCODIGO() {
		return CODIGO;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}	
}
