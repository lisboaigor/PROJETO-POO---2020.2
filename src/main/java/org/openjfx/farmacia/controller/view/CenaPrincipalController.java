package org.openjfx.farmacia.controller.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;
import org.openjfx.farmacia.controller.cliente.Cliente;
import org.openjfx.farmacia.controller.cliente.ClienteController;
import org.openjfx.farmacia.controller.produto.Estoque;
import org.openjfx.farmacia.controller.produto.ProdutoCesta;
import org.openjfx.farmacia.controller.produto.ProdutoEstoque;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CenaPrincipalController implements Initializable {
    ObservableList<ProdutoCesta> cestaProdutos = FXCollections.observableArrayList(new ArrayList<>());

    // Caixa de pesquisa
    public TextField caixaPesquisaProdutos;

    // Campos tabela de estoque
    public TableView<ProdutoEstoque> tabelaEstoque;
    public TableColumn<ProdutoEstoque, String> codigoTabela;
    public TableColumn<ProdutoEstoque, String> nomeTabela;
    public TableColumn<ProdutoEstoque, String> fabricanteTabela;
    public TableColumn<ProdutoEstoque, String> categoriaTabela;
    public TableColumn<ProdutoEstoque, String> formulaTabela;
    public TableColumn<ProdutoEstoque, Integer> quantidadeTabela;
    public TableColumn<ProdutoEstoque, Double> precoTabela;

    // Campos cesta de compras
    public TableView<ProdutoCesta> tabelaCompras;
    public TableColumn<ProdutoCesta, String> codigoProdutoCesta;
    public TableColumn<ProdutoCesta, String> nomeProdutoCesta;
    public TableColumn<ProdutoCesta, Integer> unidadesProdutoCesta;
    public TableColumn<ProdutoCesta, Double> precoProdutoCesta;

    // Botoes e textos
    public Button btnAdicionarProdutoCesta;
    public Button btnRemoverProdutoCesta;
    public Text valorTotal;

    // ComboBox
    public ComboBox<Cliente> listaClientesComboBox;

    // Inicializador do programa
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inicializarTabelaEstoque();
        inicializarCesta();
        inicializarClientes();
    }

    private void inicializarTabelaEstoque() {
        // Campos tabela de estoque
        codigoTabela.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        nomeTabela.setCellValueFactory(new PropertyValueFactory<>("nome"));
        fabricanteTabela.setCellValueFactory(new PropertyValueFactory<>("fabricante"));
        categoriaTabela.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        formulaTabela.setCellValueFactory(new PropertyValueFactory<>("formula"));
        precoTabela.setCellValueFactory(new PropertyValueFactory<>("precoUnitario"));
        quantidadeTabela.setCellValueFactory(new PropertyValueFactory<>("quantidade"));

        ObservableList<ProdutoEstoque> estoque = FXCollections.observableArrayList(new Estoque().getEstoque());

        FilteredList<ProdutoEstoque> listaFiltrada = new FilteredList<>(estoque);
        caixaPesquisaProdutos.textProperty().addListener(((observable, oldValue, newValue) -> listaFiltrada.setPredicate(produto -> {
            if (newValue == null || newValue.isEmpty())
                return true;
            String lowerCaseFilter = newValue.toLowerCase();

            if (produto.getCodigo().toLowerCase().contains(lowerCaseFilter))
                return true;
            else if (produto.getNome().toLowerCase().contains(lowerCaseFilter))
                return true;
            else if (produto.getFabricante().toLowerCase().contains(lowerCaseFilter))
                return true;
            else if (produto.getCategoria().toLowerCase().contains(lowerCaseFilter))
                return true;
            else return produto.getFormula().toLowerCase().contains(lowerCaseFilter);
        })));

        SortedList<ProdutoEstoque> estoqueOrdenado = new SortedList<>(listaFiltrada);
        estoqueOrdenado.comparatorProperty().bind(tabelaEstoque.comparatorProperty());
        tabelaEstoque.setItems(estoqueOrdenado);
    }

    private void inicializarCesta() {
        // Campos ProdutoCesta
        codigoProdutoCesta.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        nomeProdutoCesta.setCellValueFactory(new PropertyValueFactory<>("nome"));
        unidadesProdutoCesta.setCellValueFactory(new PropertyValueFactory<>("unidades"));
        precoProdutoCesta.setCellValueFactory(new PropertyValueFactory<>("preco"));

        tabelaCompras.setItems(cestaProdutos);
        unidadesProdutoCesta.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        atualizarValorTotal();
    }

    private void inicializarClientes() {
        listaClientesComboBox.setConverter(new StringConverter<>() {
            @Override
            public String toString(Cliente cliente) {
                return cliente.getCpf() + " - " + cliente.getNome();
            }

            @Override
            public Cliente fromString(String string) {
                return null;
            }
        });
        listaClientesComboBox.setItems(FXCollections.observableArrayList(new ClienteController().getClientes()));
        new ComboBoxAutoComplete<>(listaClientesComboBox);
    }

    public void adicionarProdutoCesta() {
        ProdutoEstoque produtoSelecionado = tabelaEstoque.getSelectionModel().getSelectedItem();
        tabelaCompras.getItems().add(new ProdutoCesta(produtoSelecionado.codigoProperty(), produtoSelecionado.nomeProperty(),
                produtoSelecionado.fabricanteProperty(), produtoSelecionado.categoriaProperty(),
                produtoSelecionado.formulaProperty(), produtoSelecionado.precoUnitarioProperty()));
        atualizarValorTotal();
    }

    public void atualizarValorTotal() {
        valorTotal.setText("Total : R$" + tabelaCompras.getItems().stream().mapToDouble(ProdutoCesta::getPreco).sum());
    }

    public void removerProdutoCesta() {
        ProdutoCesta produtoSelecionado = tabelaCompras.getSelectionModel().getSelectedItem();
        cestaProdutos.remove(produtoSelecionado);
        atualizarValorTotal();
    }

    public void alterarUnidades(TableColumn.CellEditEvent<ProdutoCesta, Integer> produtoCestaIntegerCellEditEvent) {
        ProdutoCesta produto = tabelaCompras.getSelectionModel().getSelectedItem();
        produto.setUnidades(produtoCestaIntegerCellEditEvent.getNewValue());
        produto.setPreco(produto.getUnidades() * produto.getPrecoUnitario());
        atualizarValorTotal();
    }

}
