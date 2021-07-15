package org.openjfx.farmacia.controller.produto;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public abstract class Produto {
    protected SimpleStringProperty codigo;
    protected SimpleStringProperty nome;
    protected SimpleStringProperty fabricante;
    protected SimpleStringProperty categoria;
    protected SimpleStringProperty formula;
    protected SimpleDoubleProperty precoUnitario;

    public String getCodigo() { return codigo.get(); }
    public SimpleStringProperty codigoProperty() { return codigo; }
    public void setCodigo(String codigo) { this.codigo.set(codigo); }

    public String getNome() { return nome.get(); }
    public SimpleStringProperty nomeProperty() { return nome; }
    public void setNome(String nome) { this.nome.set(nome); }

    public String getFabricante() { return fabricante.get(); }

    public void setFabricante(String fabricante) { this.fabricante.set(fabricante); }

    public String getCategoria() { return categoria.get(); }

    public void setCategoria(String categoria) { this.categoria.set(categoria); }
    
    public String getFormula() { return formula.get(); }

    public double getPrecoUnitario() { return precoUnitario.get(); }
    public SimpleDoubleProperty precoUnitarioProperty() { return precoUnitario; }
    public void setPrecoUnitario(double precoUnitario) { this.precoUnitario.set(precoUnitario); }
}
