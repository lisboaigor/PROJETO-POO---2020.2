package org.openjfx.farmacia.controller.view;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.openjfx.farmacia.controller.produto.Cesta;
import org.openjfx.farmacia.controller.produto.EstoqueController;
import org.openjfx.farmacia.controller.produto.ProdutoEstoque;

import java.net.URL;
import java.util.ResourceBundle;

public class CenaPrincipalController implements Initializable {

    // Campos tabela de estoque
    @FXML
    public TableView<ProdutoEstoque> tabelaEstoque;
    @FXML
    public Button adicionarCesta;
    @FXML
    TableColumn<ProdutoEstoque, String> codigoTabela;
    @FXML
    TableColumn<ProdutoEstoque, String> nomeTabela;
    @FXML
    TableColumn<ProdutoEstoque, String> fabricanteTabela;
    @FXML
    TableColumn<ProdutoEstoque, String> categoriaTabela;
    @FXML
    TableColumn<ProdutoEstoque, String> formulaTabela;
    @FXML
    TableColumn<ProdutoEstoque, Integer> quantidadeTabela;
    @FXML
    TableColumn<ProdutoEstoque, Double> precoTabela;

    // Campos cesta de compras
    @FXML
    public TableView cesta;
    @FXML
    public TableColumn codigoCesta;
    @FXML
    public TableColumn nomeCesta;
    @FXML
    public TableColumn fabricanteCesta;
    @FXML
    public TableColumn categoriaCesta;
    @FXML
    public TableColumn formulaCesta;
    @FXML
    public TableColumn unidadesCesta;
    @FXML
    public TableColumn precoCesta;

    // Inicializador de tabelas
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        codigoTabela.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        nomeTabela.setCellValueFactory(new PropertyValueFactory<>("nome"));
        fabricanteTabela.setCellValueFactory(new PropertyValueFactory<>("fabricante"));
        categoriaTabela.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        formulaTabela.setCellValueFactory(new PropertyValueFactory<>("formula"));
        precoTabela.setCellValueFactory(new PropertyValueFactory<>("preco"));
        quantidadeTabela.setCellValueFactory(new PropertyValueFactory<>("quantidade"));

        codigoCesta.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        nomeCesta.setCellValueFactory(new PropertyValueFactory<>("nome"));
        fabricanteCesta.setCellValueFactory(new PropertyValueFactory<>("fabricante"));
        categoriaCesta.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        formulaCesta.setCellValueFactory(new PropertyValueFactory<>("formula"));
        precoCesta.setCellValueFactory(new PropertyValueFactory<>("preco"));
        unidadesCesta.setCellValueFactory(new PropertyValueFactory<>("quantidade"));

        tabelaEstoque.setItems(FXCollections.observableArrayList(new EstoqueController().getEstoque()));
        cesta.setItems(FXCollections.observableArrayList(new Cesta().getCesta()));
    }

    @SuppressWarnings("unused")
    public void adicionarProdutoCesta(MouseEvent mouseEvent) {
        System.out.println("Produto adicionado!");
        //
    }

}
