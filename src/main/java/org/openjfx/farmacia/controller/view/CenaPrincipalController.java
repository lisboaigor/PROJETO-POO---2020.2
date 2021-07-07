package org.openjfx.farmacia.controller.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.openjfx.farmacia.controller.produto.EstoqueController;
import org.openjfx.farmacia.controller.produto.ProdutoEstoque;

import java.net.URL;
import java.util.ResourceBundle;

public class CenaPrincipalController implements Initializable {
    @FXML
    public TableView<ProdutoEstoque> tabela;
    @FXML
    public Button adicionarCesta;
    @FXML
    TableColumn<ProdutoEstoque, String> codigo;
    @FXML
    TableColumn<ProdutoEstoque, String> nome;
    @FXML
    TableColumn<ProdutoEstoque, String> fabricante;
    @FXML
    TableColumn<ProdutoEstoque, String> categoria;
    @FXML
    TableColumn<ProdutoEstoque, String> formula;
    @FXML
    TableColumn<ProdutoEstoque, Integer> quantidade;
    @FXML
    TableColumn<ProdutoEstoque, Double> preco;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        codigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        fabricante.setCellValueFactory(new PropertyValueFactory<>("fabricante"));
        categoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        formula.setCellValueFactory(new PropertyValueFactory<>("formula"));
        preco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        quantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));

        tabela.setItems(FXCollections.observableArrayList(new EstoqueController().getEstoque()));
    }

    public void adicionarProdutoCesta(MouseEvent mouseEvent) {
        System.out.println("Produto adicionado!");
        //
    }

}
