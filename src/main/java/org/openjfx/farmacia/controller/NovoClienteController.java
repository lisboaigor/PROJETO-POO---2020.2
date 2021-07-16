package org.openjfx.farmacia.controller;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TextField;
import org.openjfx.farmacia.cliente.Cliente;

public class NovoClienteController {
    ObservableList<Cliente> clientes;

    public TextField nomeClienteField;
    public TextField cpfClienteField;

    public void salvarNovoCliente() {
        if (!cpfClienteField.getText().isEmpty() ||
            cpfClienteField.getText() != null ||
            !nomeClienteField.getText().isEmpty() ||
            nomeClienteField.getText() != null) {
            clientes.add(new Cliente(new SimpleStringProperty(cpfClienteField.getText()),
                    				 new SimpleStringProperty(nomeClienteField.getText()),
                    				 new SimpleBooleanProperty(true)));

        }
    }

    public void setClientes(FilteredList<Cliente> clientes) {
        this.clientes = (ObservableList<Cliente>) clientes.getSource();
    }

}
