package org.openjfx.farmacia.model.vendas;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import org.openjfx.farmacia.venda.Venda;

import java.io.*;
import java.util.ArrayList;

public class VendasModel {
    private static final String SEPARATOR = System.getProperty("file.separator");
    private static final String VENDAS_PATH = "src" + SEPARATOR + "main" + SEPARATOR + "java" + SEPARATOR + "org" +
            SEPARATOR + "openjfx" + SEPARATOR + "farmacia" + SEPARATOR + "model" + SEPARATOR +
            "vendas" + SEPARATOR + "vendas.txt";

    private static ArrayList<Venda> vendas;

    public VendasModel() {
        vendas = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader(VENDAS_PATH))) {
            buffer.lines().forEach(line -> vendas.add(strToVenda(line)));
        } catch (Exception e) {
            try {
                new File("vendas.txt").createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    private static Venda strToVenda(String strVenda) {
        String[] informacoes = strVenda.split(";");
        return new Venda(new SimpleStringProperty(informacoes[0]), new SimpleStringProperty(informacoes[1]),
                         new SimpleStringProperty(informacoes[2]), new SimpleStringProperty(informacoes[3]),
                         new SimpleStringProperty(informacoes[4]), new SimpleStringProperty(informacoes[5]),
                         new SimpleStringProperty(informacoes[7]));
    }

    public ArrayList<Venda> getVendas() {
        return vendas;
    }

    public void fecharVendas(ObservableList<Venda> vendas) {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(VENDAS_PATH, false))) {
            PrintWriter printer = new PrintWriter(buffer);
            vendas.forEach(venda -> printer.println(venda.toString()));
            vendas.clear();
            printer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
