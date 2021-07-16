package org.openjfx.farmacia.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;
import org.openjfx.farmacia.App;
import org.openjfx.farmacia.cliente.Cliente;
import org.openjfx.farmacia.model.clientes.ClientesModel;
import org.openjfx.farmacia.model.estoque.EstoqueModel;
import org.openjfx.farmacia.model.estoque.RemovidosModel;
import org.openjfx.farmacia.produto.ProdutoCesta;
import org.openjfx.farmacia.produto.ProdutoEstoque;
import org.openjfx.farmacia.venda.Venda;
import org.openjfx.farmacia.model.vendas.VendasModel;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public final class MainController implements Initializable {
    private static final EstoqueModel estoqueModel = new EstoqueModel();
    private static final ClientesModel clientesModel = new ClientesModel();
    private static final VendasModel vendasModel = new VendasModel();
    private static final RemovidosModel removidosModel = new RemovidosModel();

    private final ObservableList<Cliente> clientes = FXCollections.observableArrayList(clientesModel.getClientes());
    private final ObservableList<ProdutoEstoque> estoque = FXCollections.observableArrayList(estoqueModel.getEstoque());
    private final ObservableList<Venda> vendas = FXCollections.observableArrayList(vendasModel.getVendas());
    private final ObservableList<ProdutoEstoque> removidos = FXCollections.observableArrayList(removidosModel.getRemovidos());

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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

    public Text valorTotal;

    // ComboBox
    public ComboBox<Cliente> listaClientesComboBox;

    // Inicializador do programa
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

        // Campos ProdutoCesta
        codigoProdutoCesta.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        nomeProdutoCesta.setCellValueFactory(new PropertyValueFactory<>("nome"));
        unidadesProdutoCesta.setCellValueFactory(new PropertyValueFactory<>("unidades"));
        precoProdutoCesta.setCellValueFactory(new PropertyValueFactory<>("preco"));

        inicializarTabelaEstoque();
        inicializarCesta();
        inicializarClientes();
    }

    private void inicializarTabelaEstoque() {
        FilteredList<ProdutoEstoque> listaFiltrada = estoque.filtered(produto -> produto.getQuantidade() > 0);
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

    private void inicializarCesta() {
        tabelaCompras.setItems(FXCollections.observableArrayList(new ArrayList<>()));
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
        listaClientesComboBox.setItems(FXCollections.observableArrayList(clientes.stream()
                                                                                 .filter(Cliente::isAtivado)
                                                                                 .collect(Collectors.toList())));
        new ComboBoxAutoComplete<>(listaClientesComboBox);
    }

    public void adicionarProdutoCesta() {
        ProdutoEstoque produtoSelecionado = tabelaEstoque.getSelectionModel().getSelectedItem();
        tabelaCompras.getItems().add(new ProdutoCesta(produtoSelecionado.codigoProperty(),
                                                      produtoSelecionado.nomeProperty(),
                                                      produtoSelecionado.precoUnitarioProperty()));
        atualizarValorTotal();
    }

    public void atualizarValorTotal() {
        valorTotal.setText("Total : R$" + tabelaCompras.getItems()
                                                       .stream()
                                                       .mapToDouble(ProdutoCesta::getPreco)
                                                       .sum());
    }

    public void removerProdutoCesta() {
        tabelaCompras.getItems().remove(tabelaCompras.getSelectionModel().getSelectedItem());
        atualizarValorTotal();
    }

    public void alterarUnidades(TableColumn.CellEditEvent<ProdutoCesta, Integer> produtoCestaIntegerCellEditEvent) {
        ProdutoCesta produto = tabelaCompras.getSelectionModel().getSelectedItem();
        produto.setUnidades(produtoCestaIntegerCellEditEvent.getNewValue());
        produto.setPreco(produto.getUnidades() * produto.getPrecoUnitario());
        atualizarValorTotal();
    }

    public void abrirCenaAdmClientes() throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("admClientes.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Adiministração de Clientes");
        stage.setResizable(false);
        stage.setOnCloseRequest(e -> inicializarClientes());
        ((AdmClientesController) loader.getController()).setClientes(clientes);
        stage.show();
    }

    public void abrirCenaAdmProdutos() throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("admProdutos.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Administração Produtos");
        stage.setResizable(false);

        ((AdmProdutosController) loader.getController()).setEstoque(estoque);
        ((AdmProdutosController) loader.getController()).setRemovidos(removidos);
        stage.show();
    }

    public void abrirCenaVendas() throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("vendas.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Consulta de Vendas");

        ((VendasController) loader.getController()).setVendasTabela(vendas);
        stage.show();
    }

    public void abrirCenaRemovidos() throws IOException {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("removidos.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("Consulta Removidos");

            ((ProdutosRemovidosController) loader.getController()).setTabelaRemovidos(removidos);
            stage.show();
    }

    public void finalizarVenda() {
        Cliente clienteSelecionado = listaClientesComboBox.getSelectionModel().getSelectedItem();

        tabelaCompras.getItems().forEach(compra -> {
            ProdutoEstoque produtoEstoque = tabelaEstoque.getItems()
                                                         .stream()
                                                         .filter(produto -> produto.getCodigo().equals(compra.getCodigo()))
                                                         .findAny()
                                                         .orElse(null);
            assert produtoEstoque != null;
            produtoEstoque.setQuantidade( produtoEstoque.getQuantidade() - compra.getUnidades());
        });

        tabelaEstoque.refresh();

        tabelaCompras.getItems()
                     .forEach(compra -> vendas.add(new Venda(clienteSelecionado.cpfProperty(),
                                                             clienteSelecionado.nomeProperty(),
                                                             compra.codigoProperty(),
                                                             compra.nomeProperty(),
                                                             new SimpleStringProperty(Integer.toString(compra.getUnidades())),
                                                             new SimpleStringProperty(Double.toString(compra.getPreco())),
                                                             new SimpleStringProperty(formatter.format(LocalDateTime.now())))));
        tabelaCompras.getItems().clear();
        atualizarValorTotal();
    }

    public void fecharModels() {
        estoqueModel.fecharEstoque(estoque);
        clientesModel.fecharClientes(clientes);
        vendasModel.fecharVendas(vendas);
        removidosModel.fecharRemovidos(removidos);
        System.out.println("Models fechados!");
    }
}
