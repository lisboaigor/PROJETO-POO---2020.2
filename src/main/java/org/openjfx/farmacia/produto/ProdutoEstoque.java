package org.openjfx.farmacia.produto;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ProdutoEstoque extends Produto {
	@SuppressWarnings("exports")
	public SimpleIntegerProperty quantidade;

	@SuppressWarnings("exports")
	public ProdutoEstoque(SimpleStringProperty codigo, SimpleStringProperty nome, SimpleStringProperty fabricante,
						  SimpleStringProperty categoria, SimpleStringProperty formula, SimpleDoubleProperty preco,
						  SimpleIntegerProperty quantidade) {
		this.codigo = codigo;
		this.nome = nome;
		this.fabricante = fabricante;
		this.categoria = categoria;
		this.formula = formula;
		this.precoUnitario = preco;
		this.quantidade= quantidade;
	}

	public Integer getQuantidade() { return quantidade.get();}

	public void setQuantidade(int quantidade) { this.quantidade.set(quantidade); }

	@Override
	public String toString() {
		return this.codigo.get() + ";" + this.nome.get() + ";" + this.fabricante.get() + ";" + this.categoria.get() +
				";" + this.formula.get() + ";" + this.precoUnitario.get() + ";" + this.quantidade.get();
	}
}
