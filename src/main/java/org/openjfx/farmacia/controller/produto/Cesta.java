package org.openjfx.farmacia.controller.produto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openjfx.farmacia.controller.cliente.Cliente;

public final class Cesta {
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private static final String SEPARATOR = System.getProperty("file.separator");
	private static final String VENDAS_PATH = "src" + SEPARATOR + "main" + SEPARATOR + "java" + SEPARATOR + "org"
			+ SEPARATOR + "openjfx" + SEPARATOR + "farmacia" + SEPARATOR + "model" + SEPARATOR + "vendas" + SEPARATOR
			+ "vendas_" + FORMATTER.format(LocalDate.now());

	private List<ProdutoCesta> cesta;
	private Double valorTotal;
	private Cliente cliente;

	public Cesta() {
		this.cesta = new ArrayList<ProdutoCesta>();
		this.valorTotal = 0.0;
		this.cliente = null;

		try {
			File file = new File(VENDAS_PATH);
			if (!file.exists())
				file.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removerProduto(ProdutoCesta produto) {
		cesta.remove(produto);
		valorTotal -= produto.getPreco();
	}

	public void adicionarProduto(ProdutoCesta produto) {
		cesta.add(produto);
		valorTotal += produto.getPreco();
	}

	public void registrarVenda() {
		try (BufferedWriter buffer = new BufferedWriter(new FileWriter(VENDAS_PATH))) {
			PrintWriter writter = new PrintWriter(buffer);
			cesta.forEach(item -> writter.println(cliente.getCpf()+ ";" + item.toString()));
			cesta.clear();
			writter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<ProdutoCesta> getCesta() {
		return cesta;
	}

	public void setCesta(List<ProdutoCesta> cesta) {
		this.cesta = cesta;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
