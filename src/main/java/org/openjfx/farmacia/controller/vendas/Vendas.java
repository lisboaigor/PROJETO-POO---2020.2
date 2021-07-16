package org.openjfx.farmacia.controller.vendas;

import javafx.beans.property.SimpleStringProperty;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Vendas {
    private static final String SEPARATOR = System.getProperty("file.separator");
    private static final String VENDAS_PATH = "src" + SEPARATOR + "main" + SEPARATOR + "java" + SEPARATOR + "org" +
            SEPARATOR + "openjfx" + SEPARATOR + "farmacia" + SEPARATOR + "model" + SEPARATOR +
            "vendas" + SEPARATOR + "vendas.txt";

    ArrayList<Venda> vendas;

    public Vendas() {
        vendas = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader(VENDAS_PATH))) {
            buffer.lines().forEach(line -> vendas.add(strToVenda(line)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Venda strToVenda(String strVenda) {
        String[] informacoes = strVenda.split(";");
        return new Venda(new SimpleStringProperty(informacoes[0]), new SimpleStringProperty(informacoes[1]),
                         new SimpleStringProperty(informacoes[2]), new SimpleStringProperty(informacoes[3]),
                         new SimpleStringProperty(informacoes[4]), new SimpleStringProperty(informacoes[5]),
                         new SimpleStringProperty(informacoes[7]));
    }

    public ArrayList<Venda> getVendas() {
        return vendas;
    }
}
