package org.openjfx.farmacia.controller.produto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class EstoqueController implements Controller {
	static final String SEPARATOR = System.getProperty("file.separator");
	static final String ESTOQUE_PATH = "src" + SEPARATOR + "main" + SEPARATOR + "java" + SEPARATOR + "org" + SEPARATOR
			+ "openjfx" + SEPARATOR + "farmacia" + SEPARATOR + "model" + SEPARATOR + "estoque.txt";

	private Set<Produto> estoque;

	public EstoqueController() {
		super();
		this.estoque = new HashSet<Produto>();
	}

	@Override
	public void imprimirEstoque() {
		estoque.forEach(produto -> System.out.println(produto.toString()));
	}

	@Override
	public void cadastrarProduto(Produto produto) {
		estoque.add(produto);
	}

	private Produto strToProduto(String strProduto) {
		String[] informacoes = strProduto.split(";");

		Produto produto = new Produto(informacoes[0], informacoes[1], informacoes[2], informacoes[3], informacoes[4],
				Double.parseDouble(informacoes[5]), Integer.parseInt(informacoes[6]));
		return produto;
	}

	@Override
	public void inicializarEstoque() throws IOException {
		try (BufferedReader buffer = new BufferedReader(new FileReader(ESTOQUE_PATH));) {
			buffer.lines().forEach(line -> estoque.add(strToProduto(line)));
		} catch (Exception e) {
			File file = new File(ESTOQUE_PATH);
			file.createNewFile();
		}
	}

	@Override
	public void fecharEstoque() {
		try (BufferedWriter buffer = new BufferedWriter(new FileWriter(ESTOQUE_PATH, false))) {
			PrintWriter printer = new PrintWriter(buffer);

			estoque.forEach(produto -> printer.println(produto.toString()));

			printer.close();
			buffer.close();
			estoque.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
