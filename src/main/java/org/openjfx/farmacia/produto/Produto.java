package org.openjfx.farmacia.produto;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public abstract class Produto {
    protected SimpleStringProperty codigo;
    protected SimpleStringProperty nome;
    protected SimpleStringProperty fabricante;
    protected SimpleStringProperty categoria;
    protected SimpleStringProperty formula;
    protected SimpleDoubleProperty precoUnitario;

    // Codigo
    public String getCodigo() { return codigo.get(); }
    @SuppressWarnings("exports")
	public SimpleStringProperty codigoProperty() { return codigo; }
    public void setCodigo(String codigo) { this.codigo.set(codigo); }

    // Nome
    public String getNome() { return nome.get(); }
    public SimpleStringProperty nomeProperty() { return nome; }
    public void setNome(String nome) { this.nome.set(nome); }

    // Fabricante
    public String getFabricante() { return fabricante.get(); }
    public void setFabricante(String fabricante) { this.fabricante.set(fabricante); }

    // Categoria
    public String getCategoria() { return categoria.get(); }
    public void setCategoria(String categoria) { this.categoria.set(categoria); }
    
    // Formula
    public String getFormula() { return formula.get(); }

    // Preco Unitario
    public double getPrecoUnitario() { return precoUnitario.get(); }
    @SuppressWarnings("exports")
	public SimpleDoubleProperty precoUnitarioProperty() { return precoUnitario; }
    public void setPrecoUnitario(double precoUnitario) { this.precoUnitario.set(precoUnitario); }
}
