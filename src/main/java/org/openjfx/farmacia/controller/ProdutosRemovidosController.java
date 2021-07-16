package org.openjfx.farmacia.controller;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import org.openjfx.farmacia.produto.ProdutoEstoque;

import java.net.URL;
import java.util.ResourceBundle;

public class ProdutosRemovidosController implements Initializable {
    public TableView<ProdutoEstoque> tabelaRemovidos;
    public TableColumn<ProdutoEstoque, String> codigoTabela;
    public TableColumn<ProdutoEstoque, String> nomeTabela;
    public TableColumn<ProdutoEstoque, String> fabricanteTabela;
    public TableColumn<ProdutoEstoque, String> categoriaTabela;
    public TableColumn<ProdutoEstoque, String> formulaTabela;
    public TableColumn<ProdutoEstoque, Integer> quantidadeTabela;
    public TableColumn<ProdutoEstoque, Double> precoTabela;
    public TextField caixaPesquisaProdutos;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Campos tabela de estoque
        codigoTabela.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        nomeTabela.setCellValueFactory(new PropertyValueFactory<>("nome"));
        fabricanteTabela.setCellValueFactory(new PropertyValueFactory<>("fabricante"));
        categoriaTabela.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        formulaTabela.setCellValueFactory(new PropertyValueFactory<>("formula"));
        precoTabela.setCellValueFactory(new PropertyValueFactory<>("precoUnitario"));
        quantidadeTabela.setCellValueFactory(new PropertyValueFactory<>("quantidade"));

        codigoTabela.setCellFactory(TextFieldTableCell.forTableColumn());
        nomeTabela.setCellFactory(TextFieldTableCell.forTableColumn());
        fabricanteTabela.setCellFactory(TextFieldTableCell.forTableColumn());
        categoriaTabela.setCellFactory(TextFieldTableCell.forTableColumn());
        formulaTabela.setCellFactory(TextFieldTableCell.forTableColumn());
        quantidadeTabela.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        precoTabela.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
    }

    public void setTabelaRemovidos(ObservableList<ProdutoEstoque> removidos) {
        FilteredList<ProdutoEstoque> listaFiltrada = new FilteredList<>(removidos);
        caixaPesquisaProdutos.textProperty().addListener(((observable, oldValue, newValue) -> listaFiltrada.setPredicate(produto -> {
            if (newValue == null || newValue.isEmpty())
                return true;
            String lowerCaseFilter = newValue.toLowerCase();

            if (produto.getCodigo().toLowerCase().contains(lowerCaseFilter) ||
                    produto.getNome().toLowerCase().contains(lowerCaseFilter) ||
                    produto.getFabricante().toLowerCase().contains(lowerCaseFilter) ||
                    produto.getCategoria().toLowerCase().contains(lowerCaseFilter))
                return true;
            else return produto.getFormula().toLowerCase().contains(lowerCaseFilter);
        })));
        tabelaRemovidos.setItems(listaFiltrada);
    }
}
