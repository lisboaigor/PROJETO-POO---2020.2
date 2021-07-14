package org.openjfx.farmacia.controller.view;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.openjfx.farmacia.controller.produto.Venda;

import java.net.URL;
import java.util.ResourceBundle;

public class CenaVendasController implements Initializable {
    ObservableList<Venda> vendas;

    public TextField caixaPesquisaVendas;
    public TableView<Venda> tabelaVendas;
    public TableColumn<Venda, String> cpf;
    public TableColumn<Venda, String> nomeCliente;
    public TableColumn<Venda, String> codigo;
    public TableColumn<Venda, String> nomeProduto;
    public TableColumn<Venda, String> unidades;
    public TableColumn<Venda, String> preco;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        nomeCliente.setCellValueFactory(new PropertyValueFactory<>("nomeCliente"));
        codigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        nomeProduto.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
        unidades.setCellValueFactory(new PropertyValueFactory<>("unidades"));
        preco.setCellValueFactory(new PropertyValueFactory<>("preco"));
    }

    public void setVendas(ObservableList<Venda> vendas) {
        this.vendas = vendas;
        FilteredList<Venda> listaFiltrada = new FilteredList<>(this.vendas);
        caixaPesquisaVendas.textProperty().addListener(((observable, oldValue, newValue) -> listaFiltrada.setPredicate(venda -> {
            if (newValue == null || newValue.isEmpty())
                return true;
            String lowerCaseFilter = newValue.toLowerCase();

            if (venda.getCpf().toLowerCase().contains(lowerCaseFilter) ||
                venda.getNomeCliente().toLowerCase().contains(lowerCaseFilter) ||
                venda.getCodigo().toLowerCase().contains(lowerCaseFilter) ||
                venda.getNomeProduto().toLowerCase().contains(lowerCaseFilter) ||
                venda.getUnidades().toLowerCase().contains(lowerCaseFilter))
                return true;
            else return venda.getPreco().toLowerCase().contains(lowerCaseFilter);
        })));
        tabelaVendas.setItems(listaFiltrada);
    }
}
