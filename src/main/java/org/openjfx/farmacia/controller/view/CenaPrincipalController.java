package org.openjfx.farmacia.controller.view;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import org.openjfx.farmacia.controller.cliente.ClienteController;
import org.openjfx.farmacia.controller.produto.EstoqueController;
import org.openjfx.farmacia.controller.produto.ProdutoEstoque;

import java.net.URL;
import java.util.ResourceBundle;

public class CenaPrincipalController implements Initializable {

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

    // Campos tabela de clientes
    @FXML
    public TableView tabelaClientes;
    @FXML
    public TableColumn cpf;
    @FXML
    public TableColumn nome;

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

        cpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        tabelaEstoque.setItems(FXCollections.observableArrayList(new EstoqueController().getEstoque()));
        tabelaClientes.setItems(FXCollections.observableArrayList(new ClienteController().getClientes()));

        //redimensionarColunas(tabelaEstoque);
        //redimensionarColunas(tabelaClientes);
        
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
        System.out.println("Produto adicionado!");
        //
    }

}
