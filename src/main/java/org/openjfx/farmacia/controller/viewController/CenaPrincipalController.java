package org.openjfx.farmacia.controller.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import org.openjfx.farmacia.controller.produto.EstoqueController;
import org.openjfx.farmacia.controller.produto.ProdutoEstoque;

import java.io.IOException;

public class CenaPrincipalController {
    public EstoqueController estoque;
    @FXML
    public Button adicionarCesta;
    @FXML
    public TableView<ProdutoEstoque> tabela;


    public void adicionarProdutoCesta(MouseEvent mouseEvent) {
        System.out.println("Produto adicionado!");
    }

    public void selecionarProduto(MouseEvent mouseEvent) {

    }

    public void mostrarProdutos() throws IOException {
        estoque = new EstoqueController();
        estoque.inicializarEstoque();

        tabela.getItems().addAll(estoque.getEstoque());
    }
}
