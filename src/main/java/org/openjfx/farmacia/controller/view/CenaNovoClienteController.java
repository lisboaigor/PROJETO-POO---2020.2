package org.openjfx.farmacia.controller.view;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import org.openjfx.farmacia.controller.cliente.Cliente;

public class CenaNovoClienteController {
    ObservableList<Cliente> clientes;

    public TextField nomeClienteField;
    public TextField cpfClienteField;

    public void salvarNovoCliente() {
        if (cpfClienteField.getText().isEmpty() ||
                cpfClienteField.getText() != null ||
                nomeClienteField.getText().isEmpty() ||
                nomeClienteField.getText() != null) {
            clientes.add(new Cliente(new SimpleStringProperty(cpfClienteField.getText()),
                    new SimpleStringProperty(nomeClienteField.getText()),
                    new SimpleBooleanProperty(true)));
            cpfClienteField.clear();
            nomeClienteField.clear();
        }
    }

    public void setClientes(ObservableList<Cliente> clientes) {
        this.clientes = clientes;
    }

}
