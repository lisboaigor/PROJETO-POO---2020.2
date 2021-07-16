package org.openjfx.farmacia.model.clientes;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import org.openjfx.farmacia.cliente.Cliente;

import java.io.*;
import java.util.ArrayList;

public class ClientesModel {
    private static final String SEPARATOR = System.getProperty("file.separator");
    private static final String CLIENTES_PATH = "src" + SEPARATOR + "main" + SEPARATOR + "java" + SEPARATOR + "org" +
            SEPARATOR + "openjfx" + SEPARATOR + "farmacia" + SEPARATOR + "model" + SEPARATOR + "clientes" +
            SEPARATOR + "clientes.txt";

    public static ArrayList<Cliente> clientes;

    public ClientesModel() {
        clientes = new ArrayList<>();

        try (BufferedReader buffer = new BufferedReader(new FileReader(CLIENTES_PATH))) {
            buffer.lines().forEach(line -> clientes.add(strToCliente(line)));
        } catch (Exception e) {
            try {
                new File("clientes.txt").createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
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

    public void fecharClientes(ObservableList<Cliente> clientes) {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(CLIENTES_PATH, false))) {
            PrintWriter printer = new PrintWriter(buffer);
            clientes.forEach(venda -> printer.println(venda.toString()));
            clientes.clear();
            printer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
