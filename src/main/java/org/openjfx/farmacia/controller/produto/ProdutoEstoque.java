package org.openjfx.farmacia.controller.produto;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ProdutoEstoque extends Produto {
	public SimpleIntegerProperty quantidade;

	public ProdutoEstoque(SimpleStringProperty codigo, SimpleStringProperty nome, SimpleStringProperty fabricante,
						  SimpleStringProperty categoria, SimpleStringProperty formula, SimpleDoubleProperty preco,
						  SimpleIntegerProperty quantidade) {
		this.codigo = codigo;
		this.nome = nome;
		this.fabricante = fabricante;
		this.categoria = categoria;
		this.formula = formula;
		this.preco = preco;
		this.quantidade= quantidade;
	}

	public SimpleIntegerProperty getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(SimpleIntegerProperty quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return this.codigo.get() + ";" + this.nome.get() + ";" + this.fabricante.get() + ";" + this.categoria.get() +
				";" + this.formula.get() + ";" + this.preco.get() + ";" + this.quantidade.get();
	}
}
