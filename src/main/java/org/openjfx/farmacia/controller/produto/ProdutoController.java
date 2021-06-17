package org.openjfx.farmacia.controller.produto;

public class ProdutoController {
	void acessarProduto(/* id (arg) */) {
		//toString
	};

	void cadastraProduto(/* credenciais */) {
		Produto p; // recebe credenciais no seu constructor
		// escreve as credenciais de p em suas respectivas coluna no .csv
	};

	void removeProduto(/* id (arg) */) {
		// varre a coluna de ID até encontra o ID passado como arg
		// deleta a row
		// (https://stackoverflow.com/questions/27097810/delete-a-row-in-csv-file)
	};

	// aplicar overload
	void atualizaProduto(/* id, propriedade (args) */) {
		// varre a coluna de ID até encontra o ID passado como arg
		// atualiza a propriedade
	};
}
