package org.openjfx.farmacia.controller.produto;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public abstract class Produto {
    protected SimpleStringProperty codigo;
    protected SimpleStringProperty nome;
    protected SimpleStringProperty fabricante;
    protected SimpleStringProperty categoria;
    protected SimpleStringProperty formula;
    protected SimpleDoubleProperty preco;

    @SuppressWarnings("unused")
    public String getCodigo() {
        return codigo.get();
    }

    @SuppressWarnings("unused")
    public SimpleStringProperty codigoProperty() {
        return codigo;
    }

    @SuppressWarnings("unused")
    public void setCodigo(String codigo) {
        this.codigo.set(codigo);
    }

    @SuppressWarnings("unused")
    public String getNome() {
        return nome.get();
    }

    @SuppressWarnings("unused")
    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    @SuppressWarnings("unused")
    public void setNome(String nome) {
        this.nome.set(nome);
    }

    @SuppressWarnings("unused")
    public String getFabricante() {
        return fabricante.get();
    }

    @SuppressWarnings("unused")
    public SimpleStringProperty fabricanteProperty() {
        return fabricante;
    }

    @SuppressWarnings("unused")
    public void setFabricante(String fabricante) {
        this.fabricante.set(fabricante);
    }

    @SuppressWarnings("unused")
    public String getCategoria() {
        return categoria.get();
    }

    @SuppressWarnings("unused")
    public SimpleStringProperty categoriaProperty() {
        return categoria;
    }

    @SuppressWarnings("unused")
    public void setCategoria(String categoria) {
        this.categoria.set(categoria);
    }

    @SuppressWarnings("unused")
    public String getFormula() {
        return formula.get();
    }

    @SuppressWarnings("unused")
    public SimpleStringProperty formulaProperty() {
        return formula;
    }

    @SuppressWarnings("unused")
    public void setFormula(String formula) {
        this.formula.set(formula);
    }

    @SuppressWarnings("unused")
    public double getPreco() {
        return preco.get();
    }

    @SuppressWarnings("unused")
    public SimpleDoubleProperty precoProperty() {
        return preco;
    }

    @SuppressWarnings("unused")
    public void setPreco(double preco) {
        this.preco.set(preco);
    }
}
