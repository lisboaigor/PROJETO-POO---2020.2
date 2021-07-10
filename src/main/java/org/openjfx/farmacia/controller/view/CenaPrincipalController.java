package org.openjfx.farmacia.controller.view;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import org.openjfx.farmacia.controller.produto.EstoqueController;
import org.openjfx.farmacia.controller.produto.ProdutoCesta;
import org.openjfx.farmacia.controller.produto.ProdutoEstoque;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CenaPrincipalController implements Initializable {
	private static final String SEPARATOR = System.getProperty("file.separator");
	static final String CESTA_FXML_PATH = SEPARATOR + "org" + SEPARATOR + "openjfx" + SEPARATOR + "farmacia" + SEPARATOR + "cestaCompras.fxml";
    CestaComprasController cestaComprasController;
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

    // Botoes e textos
    @FXML
    public Button abrirCesta;
    @FXML
    public Button adicionarCesta;
    @FXML
    public Text qtdProdutosCesta;

    // Inicializador do programa
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        codigoTabela.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        nomeTabela.setCellValueFactory(new PropertyValueFactory<>("nome"));
        fabricanteTabela.setCellValueFactory(new PropertyValueFactory<>("fabricante"));
        categoriaTabela.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        formulaTabela.setCellValueFactory(new PropertyValueFactory<>("formula"));
        precoTabela.setCellValueFactory(new PropertyValueFactory<>("preco"));
        quantidadeTabela.setCellValueFactory(new PropertyValueFactory<>("quantidade"));


        cestaComprasController = new CestaComprasController();

        tabelaEstoque.setItems(FXCollections.observableArrayList(new EstoqueController().getEstoque()));
        tabelaEstoque.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        qtdProdutosCesta.setText("Quantidade de produtos na cesta: " + cestaComprasController.getCestaCompras().size());
    }

    @SuppressWarnings("unused")
    public void adicionarProdutoCesta(MouseEvent mouseEvent) {
        ProdutoEstoque produtoSelecionado = tabelaEstoque.getSelectionModel().getSelectedItem();
        cestaComprasController.getCestaCompras().add(new ProdutoCesta(produtoSelecionado.codigoProperty(), produtoSelecionado.nomeProperty(),
                                          produtoSelecionado.fabricanteProperty(), produtoSelecionado.categoriaProperty(),
                                          produtoSelecionado.formulaProperty(), produtoSelecionado.precoProperty()));
        qtdProdutosCesta.setText("Quantidade de produtos na cesta: " + cestaComprasController.getCestaCompras().size());
    }

    @SuppressWarnings("unused")
    public void setMenuItemTextNomeProduto(ActionEvent actionEvent) {
        criterioFiltragemProdutos.setText(nomeProduto.getText());
    }

    @SuppressWarnings("unused")
    public void setMenuItemTextCodigoReferencia(ActionEvent actionEvent) {
        criterioFiltragemProdutos.setText(codigoReferencia.getText());
    }

    @SuppressWarnings("unused")
    public void setMenuItemTextFabricante(ActionEvent actionEvent) {
        criterioFiltragemProdutos.setText(fabricante.getText());
    }

    @SuppressWarnings("unused")
    public void setMenuItemTextCategoria(ActionEvent actionEvent) {
        criterioFiltragemProdutos.setText(categoria.getText());
    }

    @SuppressWarnings("unused")
    public void setMenuItemTextFormula(ActionEvent actionEvent) {
        criterioFiltragemProdutos.setText(formula.getText());
    }

    @SuppressWarnings("unused")
    public void irParaCesta(MouseEvent mouseEvent) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource(CESTA_FXML_PATH));
    	Stage stage = new Stage();
    	stage.setScene(new Scene(loader.load()));
    	stage.show();
    }
}
