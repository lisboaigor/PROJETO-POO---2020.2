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
	private static final String SEPARATOR = System.getProperty("file.separator");
	private static final String ESTOQUE_PATH = "src" + SEPARATOR + "main" + SEPARATOR + "java" + SEPARATOR + "org" + SEPARATOR
			+ "openjfx" + SEPARATOR + "farmacia" + SEPARATOR + "model" + SEPARATOR + "estoque" + SEPARATOR +"estoque.txt";

	private Set<ProdutoEstoque> estoque;

	public EstoqueController() {
		super();
		this.estoque = new HashSet<ProdutoEstoque>();
	}

	@Override
	public void imprimirEstoque() {
		estoque.forEach(produto -> System.out.println(produto.toString()));
	}

	@Override
	public void cadastrarProduto(ProdutoEstoque produto) {
		estoque.add(produto);
	}

	private ProdutoEstoque strToProduto(String strProduto) {
		String[] informacoes = strProduto.split(";");

		ProdutoEstoque produto = new ProdutoEstoque(informacoes[0], informacoes[1], informacoes[2], informacoes[3], informacoes[4],
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
			estoque.clear();			
			printer.close();
			buffer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
