package org.openjfx.farmacia.controller.produto;

public final class Produto {
	private final String codigo;
	private String nome;
	private String fabricante;
	private String categoria;
	
	private double preco;
	private int estoque;
	
	public Produto(String codigo, String nome, String fabricante, String categoria, double preco, int estoque) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.fabricante = fabricante;
		this.categoria = categoria;
		this.preco = preco;
		this.estoque = estoque;
	}
	
	public void vender(int quantidadeVendida) {
		estoque -= quantidadeVendida;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getCodigo() {
		return codigo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public String toString() {
		return codigo + " " + nome + " " + fabricante + " " + categoria + " " + preco + " " + estoque;
	}
}
