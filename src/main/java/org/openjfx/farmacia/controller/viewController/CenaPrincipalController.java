package org.openjfx.farmacia.controller.viewController;

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

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CenaPrincipalController implements Initializable {
    @FXML
    public TableView<ProdutoEstoque> tabela;
    @FXML
    public Button adicionarCesta;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.tabela = new TableView<ProdutoEstoque>();

        TableColumn<ProdutoEstoque, String> codigo = new TableColumn<ProdutoEstoque, String>("Codigo");
        TableColumn<ProdutoEstoque, String> nome = new TableColumn<ProdutoEstoque, String>("Nome");
        TableColumn<ProdutoEstoque, String> fabricante = new TableColumn<ProdutoEstoque, String>("Fabricante");
        TableColumn<ProdutoEstoque, String> categoria = new TableColumn<ProdutoEstoque, String>("Categoria");
        TableColumn<ProdutoEstoque, String> formula = new TableColumn<ProdutoEstoque, String>("Formula");
        TableColumn<ProdutoEstoque, Integer> quantidade = new TableColumn<ProdutoEstoque, Integer>("Quantidade");
        TableColumn<ProdutoEstoque, Double> preco = new TableColumn<ProdutoEstoque, Double>("Preco");

        EstoqueController estoque = new EstoqueController();

        try {
            estoque.inicializarEstoque();
        } catch (IOException e) {
            e.printStackTrace();
        }

        estoque.imprimirEstoque();

        final ObservableList<ProdutoEstoque> conteudos = FXCollections.observableList(new ArrayList<>(estoque.getEstoque()));
        tabela.getColumns().addAll(codigo, fabricante, categoria, formula, quantidade, preco);
        tabela.getItems().addAll(conteudos);

        codigo.setCellValueFactory(new PropertyValueFactory<ProdutoEstoque, String>("codigo"));
        nome.setCellValueFactory(new PropertyValueFactory<ProdutoEstoque, String>("nome"));
        fabricante.setCellValueFactory(new PropertyValueFactory<ProdutoEstoque, String>("fabricante"));
        categoria.setCellValueFactory(new PropertyValueFactory<ProdutoEstoque, String>("categoria"));
        formula.setCellValueFactory(new PropertyValueFactory<ProdutoEstoque, String>("formula"));
        quantidade.setCellValueFactory(new PropertyValueFactory<ProdutoEstoque, Integer>("quantidade"));
        preco.setCellValueFactory(new PropertyValueFactory<ProdutoEstoque, Double>("preco"));
    }

    public void adicionarProdutoCesta(MouseEvent mouseEvent) {
        System.out.println("Produto adicionado!");
    }

}
