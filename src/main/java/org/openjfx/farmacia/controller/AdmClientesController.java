package org.openjfx.farmacia.controller;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.BooleanStringConverter;
import org.openjfx.farmacia.App;
import org.openjfx.farmacia.cliente.Cliente;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdmClientesController implements Initializable {
    public TableView<Cliente> tabelaClientes;
    public TableColumn<Cliente, String> cpf;
    public TableColumn<Cliente, String> nome;
    public TableColumn<Cliente, Boolean> ativado;

    public TextField caixaPesquisaClientes;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        ativado.setCellValueFactory(new PropertyValueFactory<>("ativado"));

        cpf.setCellFactory(TextFieldTableCell.forTableColumn());
        nome.setCellFactory(TextFieldTableCell.forTableColumn());
        ativado.setCellFactory(TextFieldTableCell.forTableColumn(new BooleanStringConverter()));
    }

    public void setClientes(ObservableList<Cliente> clientes) {
        FilteredList<Cliente> listaClientes = new FilteredList<>(clientes);
        caixaPesquisaClientes.textProperty().addListener(((observable, oldValue, newValue) -> listaClientes.setPredicate(cliente -> {
            if (newValue == null || newValue.isEmpty())
                return true;
            String lowerCaseFilter = newValue.toLowerCase();

            if (cliente.getCpf().toLowerCase().contains(lowerCaseFilter) ||
                    cliente.getNome().toLowerCase().contains(lowerCaseFilter))
                return true;
            else return Boolean.toString(cliente.isAtivado()).equals(newValue);
        })));

        tabelaClientes.setItems(listaClientes);
    }

    public void desativarCliente() {
        tabelaClientes.getSelectionModel().getSelectedItem().setAtivado(false);
    }

    public void abrirCenaNovoCliente() throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("novoCliente.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));

        ((NovoClienteController) loader.getController()).setClientes((FilteredList<Cliente>) tabelaClientes.getItems());

        stage.setTitle("Cadastro de Cliente");
        stage.setResizable(false);
        stage.show();
    }
}
