package org.openjfx.farmacia.controller.cliente;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ClienteController {
    private static final String SEPARATOR = System.getProperty("file.separator");
    private static final String CLIENTES_PATH = "src" + SEPARATOR + "main" + SEPARATOR + "java" + SEPARATOR + "org" +
            SEPARATOR + "openjfx" + SEPARATOR + "farmacia" + SEPARATOR + "model" + SEPARATOR + "clientes" +
            SEPARATOR + "clientes.txt";

    public ArrayList<Cliente> clientes;

    public ClienteController() {
        this.clientes = new ArrayList<>();

        try (BufferedReader buffer = new BufferedReader(new FileReader(CLIENTES_PATH))) {
            buffer.lines().forEach(line -> clientes.add(strToCliente(line)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Cliente strToCliente(String strCliente) {
        String[] informacoes = strCliente.split(";");
        return new Cliente(new SimpleStringProperty(informacoes[0]), new SimpleStringProperty(informacoes[1]),
                new SimpleBooleanProperty(Boolean.parseBoolean(informacoes[2])));
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

}
