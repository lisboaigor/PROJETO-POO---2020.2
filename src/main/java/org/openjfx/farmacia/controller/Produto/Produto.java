package org.openjfx.farmacia.controller.Produto;

public class Produto {
	private String nome;
	private String fabricante;
	private String codigo;
	
	private double preco;
	private int estoque;
	
	public Produto(String nome, String fabricante, String codigo, double preco, int estoque) {
		super();
		this.nome = nome;
		this.fabricante = fabricante;
		this.codigo = codigo;
		this.preco = preco;
		this.estoque = estoque;
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

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", fabricante=" + fabricante + ", codigo=" + codigo + ", preco=" + preco
				+ ", estoque=" + estoque + "]";
	}

}
