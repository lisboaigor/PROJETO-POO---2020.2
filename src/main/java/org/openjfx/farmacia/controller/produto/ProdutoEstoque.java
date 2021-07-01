package org.openjfx.farmacia.controller.produto;

public class ProdutoEstoque extends Produto {
	private int qtdEstoque;

	public ProdutoEstoque(String codigo, String nome, String fabricante, String categoria, String formula, double preco,
			int qtdEstoque) {
		super();
		this.setCodigo(codigo);
		this.setNome(nome);
		this.setFabricante(fabricante);
		this.setCategoria(categoria);
		this.setFormula(formula);
		this.setPreco(preco);
		this.qtdEstoque = qtdEstoque;
	}

	public void vender(int quantidadeVendida) {
		qtdEstoque -= quantidadeVendida;
	}

	public int getEstoque() {
		return qtdEstoque;
	}

	public void setEstoque(int estoque) {
		this.qtdEstoque = estoque;
	}

	@Override
	public String toString() {
		return this.getCodigo() + ";" + this.getNome() + ";" + this.getFabricante() + ";" + this.getCategoria() + ";"
				+ this.getFormula() + ";" + this.getPreco() + ";" + qtdEstoque;
	}
}
