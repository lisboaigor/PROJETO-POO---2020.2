package org.openjfx.farmacia.controller.produto;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ProdutoCesta extends Produto {
    protected SimpleIntegerProperty unidades;

    public ProdutoCesta(SimpleStringProperty codigo, SimpleStringProperty nome, SimpleStringProperty fabricante,
                         SimpleStringProperty categoria, SimpleStringProperty formula, SimpleDoubleProperty preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.fabricante = fabricante;
        this.categoria = categoria;
        this.formula = formula;
        this.preco = preco;
        this.unidades = new SimpleIntegerProperty(0);
    }

    public int getUnidades() {
        return unidades.get();
    }

    public SimpleIntegerProperty unidadesProperty() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades.set(unidades);
    }
}
