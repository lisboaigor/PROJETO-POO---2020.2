package org.openjfx.farmacia.produto;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ProdutoCesta extends Produto {
    protected SimpleIntegerProperty unidades;
    protected SimpleDoubleProperty preco;

    @SuppressWarnings("exports")
	public ProdutoCesta(SimpleStringProperty codigo, SimpleStringProperty nome, SimpleDoubleProperty preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.precoUnitario = preco;
        this.preco = new SimpleDoubleProperty(preco.get());
        this.unidades = new SimpleIntegerProperty(1);
    }

    public int getUnidades() {
        return unidades.get();
    }

    public void setUnidades(int unidades) {
        this.unidades.set(unidades);
    }

    public double getPreco() { return preco.get(); }

    public void setPreco(double preco) { this.preco.set(preco); }

    @Override
    public String toString() {
        return codigo.get() + ";" + nome.get() + ";" + unidades.get() + ";" + preco.get();
    }
}
