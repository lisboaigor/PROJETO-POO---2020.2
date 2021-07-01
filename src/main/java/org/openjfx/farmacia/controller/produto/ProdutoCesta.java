package org.openjfx.farmacia.controller.produto;

public class ProdutoCesta extends Produto {
	private int quantidade;

	public ProdutoCesta(String codigo, String nome, String fabricante, String categoria, String formula, double preco,
			int quantidade) {
		super();
		this.setCodigo(codigo);
		this.setNome(nome);
		this.setFabricante(fabricante);
		this.setCategoria(categoria);
		this.setFormula(formula);
		this.setPreco(preco);
		this.quantidade = quantidade;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return this.getCodigo() + ";" + this.getNome() + ";" + this.getFabricante() + ";" + this.getCategoria() + ";"
				+ this.getFormula() + ";" + this.getPreco() + ";" + this.getQuantidade();
	}

}
