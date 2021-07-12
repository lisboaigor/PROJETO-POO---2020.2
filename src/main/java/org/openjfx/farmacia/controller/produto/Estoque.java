package org.openjfx.farmacia.controller.produto;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private static final String SEPARATOR = System.getProperty("file.separator");

    private static final String ESTOQUE_PATH = "src" + SEPARATOR + "main" + SEPARATOR + "java" + SEPARATOR + "org" +
            SEPARATOR + "openjfx" + SEPARATOR + "farmacia" + SEPARATOR + "model" + SEPARATOR +
            "estoque" + SEPARATOR + "estoque.txt";

    private static final String EXCLUIDOS = "src" + SEPARATOR + "main" + SEPARATOR + "java" + SEPARATOR + "org" +
            SEPARATOR + "openjfx" + SEPARATOR + "farmacia" + SEPARATOR + "model" + SEPARATOR +
            "estoque" + SEPARATOR + "excluidos.txt";

    private final ArrayList<ProdutoEstoque> estoque;

    public Estoque() {
        super();
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

    public void fecharEstoque() {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(ESTOQUE_PATH, false))) {
            PrintWriter printer = new PrintWriter(buffer);
            estoque.forEach(produto -> printer.println(produto.toString()));
            estoque.clear();
            printer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ProdutoEstoque> listarExcluidos() {
        List<ProdutoEstoque> excluidos = new ArrayList<>();

        try (BufferedReader buffer = new BufferedReader(new FileReader(EXCLUIDOS))) {
            buffer.lines().forEach(produto -> excluidos.add(strToProduto(produto)));
            return excluidos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<ProdutoEstoque> getEstoque() {
        return estoque;
    }
}
