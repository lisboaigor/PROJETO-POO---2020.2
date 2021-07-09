package org.openjfx.farmacia.controller.view;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import org.openjfx.farmacia.controller.Logs;
import org.openjfx.farmacia.controller.cliente.ClienteController;
import org.openjfx.farmacia.controller.produto.EstoqueController;
import org.openjfx.farmacia.controller.produto.ProdutoEstoque;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class CenaPrincipalController implements Initializable {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");

    // Caixa de pesquisa
    @FXML
    public TextField caixaPesquisaProdutos;

    // Menu button
    @FXML
    public MenuButton criterioFiltragemProdutos;
    @FXML
    public MenuItem nomeProduto;
    @FXML
    public MenuItem codigoReferencia;
    @FXML
    public MenuItem fabricante;
    @FXML
    public MenuItem categoria;
    @FXML
    public MenuItem formula;

    // Campos tabela de estoque
    @FXML
    public TableView<ProdutoEstoque> tabelaEstoque;
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

        tabelaEstoque.setItems(FXCollections.observableArrayList(new EstoqueController().getEstoque()));      
        tabelaEstoque.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    private static void redimensionarColunas(TableView<?> tabela) {
        tabela.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
        tabela.getColumns().stream().forEach(coluna -> {
            Text t = new Text(coluna.getText());
            double max = t.getLayoutBounds().getWidth();
            for (int i = 0; i < tabela.getItems().size(); i++)
                if (coluna.getCellData(i) != null) {
                    t = new Text(coluna.getCellData(i).toString());
                    double largura = t.getLayoutBounds().getWidth();
                    if (largura > max) {
                        max = largura;
                    }
                }
            coluna.setPrefWidth(max + 10.0d);
        });
    }

    @SuppressWarnings("unused")
    public void adicionarProdutoCesta(MouseEvent mouseEvent) {
        logs.getItems().add(formatter.format(new Date()) + " | Produto adicionado ");
        logs.scrollTo(logs.getItems().size());
    }
    
    public void setMenuItemTextNomeProduto(ActionEvent actionEvent) {
        criterioFiltragemProdutos.setText(nomeProduto.getText());
    }

    public void setMenuItemTextCodigoReferencia(ActionEvent actionEvent) {
        criterioFiltragemProdutos.setText(codigoReferencia.getText());
    }

    public void setMenuItemTextFabricante(ActionEvent actionEvent) {
        criterioFiltragemProdutos.setText(fabricante.getText());
    }

    public void setMenuItemTextCategoria(ActionEvent actionEvent) {
        criterioFiltragemProdutos.setText(categoria.getText());
    }

    public void setMenuItemTextFormula(ActionEvent actionEvent) {
        criterioFiltragemProdutos.setText(formula.getText());
    }
}
