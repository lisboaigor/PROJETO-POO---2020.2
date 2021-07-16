package org.openjfx.farmacia.model.estoque;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import org.openjfx.farmacia.produto.ProdutoEstoque;

import java.io.*;
import java.util.ArrayList;

public class RemovidosModel {
    private static final String SEPARATOR = System.getProperty("file.separator");
    private static final String EXCLUIDOS_PATH = "src" + SEPARATOR + "main" + SEPARATOR + "java" + SEPARATOR + "org" +
            SEPARATOR + "openjfx" + SEPARATOR + "farmacia" + SEPARATOR + "model" + SEPARATOR +
            "estoque" + SEPARATOR + "removidos.txt";

    private final ArrayList<ProdutoEstoque> removidos;

    public RemovidosModel() {
        removidos = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader(EXCLUIDOS_PATH))) {
            buffer.lines().forEach(line -> removidos.add(strToProduto(line)));
        } catch (Exception e) {
            try {
                new File("removidos.txt").createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    private ProdutoEstoque strToProduto(String strProduto) {
        String[] informacoes = strProduto.split(";");
        return new ProdutoEstoque(new SimpleStringProperty(informacoes[0]), new SimpleStringProperty(informacoes[1]),
                new SimpleStringProperty(informacoes[2]), new SimpleStringProperty(informacoes[3]),
                new SimpleStringProperty(informacoes[4]), new SimpleDoubleProperty(Double.parseDouble(informacoes[5])),
                new SimpleIntegerProperty(Integer.parseInt(informacoes[6])));
    }

    public void fecharRemovidos(ObservableList<ProdutoEstoque> removidos) {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(EXCLUIDOS_PATH, false))) {
            PrintWriter printer = new PrintWriter(buffer);
            removidos.forEach(produto -> printer.println(produto.toString()));
            removidos.clear();
            printer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ProdutoEstoque> getRemovidos() {
        return removidos;
    }
}
