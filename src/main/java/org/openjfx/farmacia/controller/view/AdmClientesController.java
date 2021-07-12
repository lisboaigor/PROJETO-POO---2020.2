package org.openjfx.farmacia.controller.view;

import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.openjfx.farmacia.controller.cliente.Cliente;
import org.openjfx.farmacia.controller.cliente.ClienteController;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdmClientesController implements Initializable {
    private ArrayList<Cliente> clientes;

    public TextField campoPesquisa;

    public TableView tabelaClientes;
    public TableColumn cpf;
    public TableColumn nome;
    public TableColumn cadastrado;

    public MenuButton menuItem;
    public Button btnCadastrarCliente;
    public Button btnRemoverCliente;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cpf.setCellFactory(new PropertyValueFactory<>("cpf"));
        nome.setCellFactory(new PropertyValueFactory<>("nome"));
        cadastrado.setCellFactory(new PropertyValueFactory<>("cadastrado"));

        clientes = new ClienteController().getClientes();
        tabelaClientes.setItems(FXCollections.observableArrayList(clientes));
    }

    public void cadastrarCliente() {
        //TODO
    }

    public void removerCliente() {
        //TODO
    }
}
