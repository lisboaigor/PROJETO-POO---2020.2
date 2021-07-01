package org.openjfx.farmacia.controller.produto;

import java.io.IOException;

public interface Controller {
	public void imprimirEstoque();
	public void cadastrarProduto(ProdutoEstoque produto);
	public void inicializarEstoque() throws IOException;
	public void fecharEstoque();
}
