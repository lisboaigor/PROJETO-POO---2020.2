package org.openjfx.farmacia.controller.produto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class EstoqueController {
	static final String SEPARATOR = System.getProperty("file.separator");
	static final String ESTOQUE_PATH = "src" + SEPARATOR + "main" + SEPARATOR + "java" + SEPARATOR + "org" + SEPARATOR + 
									   "openjfx" + SEPARATOR + "farmacia" + SEPARATOR + "model" + SEPARATOR + "estoque.txt";
	
	private Set<Produto> estoque;
	
	public EstoqueController() {
		super();
		this.estoque = new HashSet<Produto>();
	}
	
	public void imprimirEstoque() {
		estoque.forEach(produto -> System.out.println(produto.toString()));
	}

	public void cadastrarProduto(Produto produto) {
		estoque.add(produto);
	};

	private Produto strToProduto(String strProduto) {
		String[] informacoes = strProduto.split(";");

		Produto produto = new Produto(informacoes[0], informacoes[1], informacoes[2], informacoes[3], informacoes[4],
									  Double.parseDouble(informacoes[5]), Integer.parseInt(informacoes[6]));
		return produto;
	}
	
	void acessarProduto(/* id (arg) */) {
		//toString
	};


	void removerProduto(/* id (arg) */) {
		// varre a coluna de ID até encontra o ID passado como arg
		// deleta a row
		// (https://stackoverflow.com/questions/27097810/delete-a-row-in-csv-file)
	};

	// aplicar overload
	void atualizarProduto(/* id, propriedade (args) */) {
		// varre a coluna de ID até encontra o ID passado como arg
		// atualiza a propriedade
	};
	
	public void inicializarEstoque() throws IOException {
		try (BufferedReader buffer = new BufferedReader(new FileReader(ESTOQUE_PATH))) {
			//buffer.lines().forEach(line -> estoque.add(strToProduto(line)));
			/*
			String line;
			while(!(line = buffer.readLine()).isBlank()) {
				estoque.add(strToProduto(line))
			}
			*/
		} catch (Exception e) {
			FileWriter file = new FileWriter(ESTOQUE_PATH, false);
			file.close();
		}
	}

	public void fecharEstoque() {
		try (BufferedWriter buffer = new BufferedWriter(new FileWriter(ESTOQUE_PATH))) {
			PrintWriter printer = new PrintWriter(buffer);
			printer.print("");
			estoque.forEach(produto -> printer.println(produto.toString()));
			estoque.clear();
			printer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
