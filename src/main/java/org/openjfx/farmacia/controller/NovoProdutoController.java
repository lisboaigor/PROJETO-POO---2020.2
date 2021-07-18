package org.openjfx.farmacia.controller;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TextField;
import org.openjfx.farmacia.produto.ProdutoEstoque;

public class NovoProdutoController {
    @SuppressWarnings("exports")
	public TextField campoFormula;
    @SuppressWarnings("exports")
	public TextField campoQuantidade;
    @SuppressWarnings("exports")
	public TextField campoCategoria;
    @SuppressWarnings("exports")
	public TextField campoFabricante;
    public TextField campoNome;
    public TextField campoCodigo;
    public TextField campoPreco;

    ObservableList<ProdutoEstoque> estoque;

    public void setEstoque(FilteredList<ProdutoEstoque> estoque) {
        this.estoque = (ObservableList<ProdutoEstoque>) estoque.getSource();
    }

    public void salvarNovoProduto() {
        if ((!campoCodigo.getText().isEmpty() || campoCategoria.getText() != null) &&
                (!campoNome.getText().isEmpty() || campoNome.getText() != null) &&
                (!campoFabricante.getText().isEmpty() || campoFabricante.getText() != null) &&
                (!campoCategoria.getText().isEmpty() || campoCategoria.getText() != null) &&
                (!campoFormula.getText().isEmpty() || campoFormula.getText() != null) &&
                (!campoQuantidade.getText().isEmpty() || campoQuantidade.getText() != null) &&
                (!campoPreco.getText().isEmpty() || campoQuantidade.getText() != null)) {
            estoque.add(new ProdutoEstoque(new SimpleStringProperty(campoCodigo.getText()),
                        new SimpleStringProperty(campoNome.getText()), new SimpleStringProperty(campoFabricante.getText()),
                        new SimpleStringProperty(campoCategoria.getText()), new SimpleStringProperty(campoFormula.getText()),
                        new SimpleDoubleProperty(Double.parseDouble(campoPreco.getText())), new SimpleIntegerProperty(Integer.parseInt(campoQuantidade.getText()))));
            campoCodigo.clear();
            campoNome.clear();
            campoFabricante.clear();
            campoCategoria.clear();
            campoFormula.clear();
            campoQuantidade.clear();
            campoPreco.clear();
        }
    }
}
