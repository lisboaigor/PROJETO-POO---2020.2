package org.openjfx.farmacia.controller;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import org.openjfx.farmacia.App;
import org.openjfx.farmacia.produto.ProdutoEstoque;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdmProdutosController implements Initializable {
    public TableView<ProdutoEstoque> tabelaEstoque;
    public TableColumn<ProdutoEstoque, String> codigoTabela;
    public TableColumn<ProdutoEstoque, String> nomeTabela;
    public TableColumn<ProdutoEstoque, String> fabricanteTabela;
    public TableColumn<ProdutoEstoque, String> categoriaTabela;
    public TableColumn<ProdutoEstoque, String> formulaTabela;
    public TableColumn<ProdutoEstoque, Integer> quantidadeTabela;
    public TableColumn<ProdutoEstoque, Double> precoTabela;
    @SuppressWarnings("exports")
	public TextField caixaPesquisaProdutos;

    private ObservableList<ProdutoEstoque> removidos;

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

    public void setEstoque(ObservableList<ProdutoEstoque> estoque) {
        FilteredList<ProdutoEstoque> listaFiltrada = new FilteredList<>(estoque);
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
        tabelaEstoque.setItems(listaFiltrada);
    }

    public void setRemovidos(ObservableList<ProdutoEstoque> removidos) {
        this.removidos = removidos;
    }
    public void abrirCenaNovoProduto() throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("novoProduto.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));

        ((NovoProdutoController) loader.getController()).setEstoque((FilteredList<ProdutoEstoque>) tabelaEstoque.getItems());

        stage.setTitle("Cadastro de Cliente");
        stage.setResizable(false);
        stage.show();
    }

    public void alterarCodigo(TableColumn.CellEditEvent<ProdutoEstoque, String> produtoEstoqueCellEditEvent) {
        ProdutoEstoque produto = tabelaEstoque.getSelectionModel().getSelectedItem();
        produto.setCodigo(produtoEstoqueCellEditEvent.getNewValue());
    }

    public void alterarNome(TableColumn.CellEditEvent<ProdutoEstoque, String> produtoEstoqueCellEditEvent) {
        ProdutoEstoque produto = tabelaEstoque.getSelectionModel().getSelectedItem();
        produto.setNome(produtoEstoqueCellEditEvent.getNewValue());
    }

    public void alterarFabricante(TableColumn.CellEditEvent<ProdutoEstoque, String> produtoEstoqueCellEditEvent) {
        ProdutoEstoque produto = tabelaEstoque.getSelectionModel().getSelectedItem();
        produto.setFabricante(produtoEstoqueCellEditEvent.getNewValue());
    }

    public void alterarCategoria(TableColumn.CellEditEvent<ProdutoEstoque, String> produtoEstoqueCellEditEvent) {
        ProdutoEstoque produto = tabelaEstoque.getSelectionModel().getSelectedItem();
        produto.setCategoria(produtoEstoqueCellEditEvent.getNewValue());
    }

    public void alterarFormula(TableColumn.CellEditEvent<ProdutoEstoque, String> produtoEstoqueCellEditEvent) {
        ProdutoEstoque produto = tabelaEstoque.getSelectionModel().getSelectedItem();
        produto.setCategoria(produtoEstoqueCellEditEvent.getNewValue());
    }

    public void alterarQuantidade(TableColumn.CellEditEvent<ProdutoEstoque, Integer> produtoCestaIntegerCellEditEvent) {
        ProdutoEstoque produto = tabelaEstoque.getSelectionModel().getSelectedItem();
        produto.setQuantidade(produtoCestaIntegerCellEditEvent.getNewValue());
    }

    public void alterarPreco(TableColumn.CellEditEvent<ProdutoEstoque, Double> produtoCestaDoubleCellEditEvent) {
        ProdutoEstoque produto = tabelaEstoque.getSelectionModel().getSelectedItem();
        produto.setPrecoUnitario(produtoCestaDoubleCellEditEvent.getNewValue());
    }

    public void removerProdutoEstoque() {
        removidos.add(tabelaEstoque.getSelectionModel().getSelectedItem());
        ((FilteredList<ProdutoEstoque>) tabelaEstoque.getItems())
                                                     .getSource()
                                                     .remove(tabelaEstoque.getSelectionModel().getSelectedItem());
    }
}
