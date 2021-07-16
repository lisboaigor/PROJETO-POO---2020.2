package org.openjfx.farmacia.model.estoque;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import org.openjfx.farmacia.produto.ProdutoEstoque;

import java.io.*;
import java.util.ArrayList;

public class EstoqueModel {
    private static final String SEPARATOR = System.getProperty("file.separator");
    private static final String ESTOQUE_PATH = "src" + SEPARATOR + "main" + SEPARATOR + "java" + SEPARATOR + "org" +
                                SEPARATOR + "openjfx" + SEPARATOR + "farmacia" + SEPARATOR + "model" + SEPARATOR +
                                "estoque" + SEPARATOR + "estoque.txt";

    private final ArrayList<ProdutoEstoque> estoque;

    public EstoqueModel() {
        this.estoque = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader(ESTOQUE_PATH))) {
            buffer.lines().forEach(line -> estoque.add(strToProduto(line)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ProdutoEstoque strToProduto(String strProduto) {
        String[] informacoes = strProduto.split(";");
        return new ProdutoEstoque(new SimpleStringProperty(informacoes[0]), new SimpleStringProperty(informacoes[1]),
                new SimpleStringProperty(informacoes[2]), new SimpleStringProperty(informacoes[3]),
                new SimpleStringProperty(informacoes[4]), new SimpleDoubleProperty(Double.parseDouble(informacoes[5])),
                new SimpleIntegerProperty(Integer.parseInt(informacoes[6])));
    }

    public void fecharEstoque(ObservableList<ProdutoEstoque> estoque) {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(ESTOQUE_PATH, false))) {
            PrintWriter printer = new PrintWriter(buffer);
            estoque.forEach(produto -> printer.println(produto.toString()));
            estoque.clear();
            printer.close();
        } catch (Exception e) {
            try {
                new File("estoque.txt").createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    public ArrayList<ProdutoEstoque> getEstoque() {
        return estoque;
    }
}
