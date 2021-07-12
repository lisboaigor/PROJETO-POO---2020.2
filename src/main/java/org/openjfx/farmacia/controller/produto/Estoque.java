package org.openjfx.farmacia.controller.produto;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Estoque implements Controller {
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

    @Override
    public void imprimirEstoque() {
        estoque.forEach(produto -> System.out.println(produto.toString()));
    }

    @Override
    public void cadastrarProduto(ProdutoEstoque produto) {
        estoque.add(produto);
    }

    @Override
    public void excluirProduto(ProdutoEstoque produto) {
        estoque.remove(produto);
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(EXCLUIDOS, true)))) {
            writer.println(produto.toString());
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

    @Override
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

    @Override
    public List<ProdutoEstoque> filtrarCategoria(String categoria) {
        return estoque.stream()
                .filter(produto -> produto.getCategoria().toUpperCase().equals(categoria))
                .collect(Collectors.toList());
    }

    @Override
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
