package org.openjfx.farmacia.controller.produto;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ProdutoCesta extends Produto {
	protected SimpleIntegerProperty unidades;

	public ProdutoCesta(SimpleStringProperty codigo, SimpleStringProperty nome, SimpleStringProperty fabricante,
						SimpleStringProperty categoria, SimpleStringProperty formula, SimpleDoubleProperty preco) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.fabricante = fabricante;
		this.categoria = categoria;
		this.formula = formula;
		this.preco = preco;
		this.unidades.set(1);
	}

	@SuppressWarnings("unused")
	public int getUnidades() {
		return unidades.get();
	}

	@SuppressWarnings("unused")
	public SimpleIntegerProperty unidadesProperty() {
		return unidades;
	}

	@SuppressWarnings("unused")
	public void setUnidades(int unidades) {
		this.unidades.set(unidades);
	}

	@Override
	public String toString() {
		return this.codigo.get() + ";" + this.nome.get() + ";" + this.fabricante.get() + ";" + this.categoria.get() + ";"
				+ this.formula.get() + ";" + this.preco.get() + ";" + this.unidades.get();
	}

}
