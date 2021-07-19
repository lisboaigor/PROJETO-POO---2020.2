package org.openjfx.farmacia.controller;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TextField;
import org.openjfx.farmacia.produto.InvalidProductException;
import org.openjfx.farmacia.produto.NegativeAmountException;
import org.openjfx.farmacia.produto.NegativePriceException;
import org.openjfx.farmacia.produto.ProdutoEstoque;

public class NovoProdutoController {
	@SuppressWarnings("exports")
	public TextField campoFormula;
	@SuppressWarnings("exports")
	public TextField campoQuantidade;
	@SuppressWarnings("exports")
	public TextField campoCategoria;
	@SuppressWarnings("exports")
	public TextField campoFabricante;
	@SuppressWarnings("exports")
	public TextField campoNome;
	@SuppressWarnings("exports")
	public TextField campoCodigo;
	@SuppressWarnings("exports")
	public TextField campoPreco;

	public ObservableList<ProdutoEstoque> estoque;

	@SuppressWarnings("unchecked")
	public void setEstoque(FilteredList<ProdutoEstoque> estoque) {
		this.estoque = (ObservableList<ProdutoEstoque>) estoque.getSource();
	}

	public void salvarNovoProduto() throws InvalidProductException, Exception {
		double preco = Double.parseDouble(campoPreco.getText());
		int quantidade = Integer.parseInt(campoQuantidade.getText());

		if ((!campoCodigo.getText().isEmpty() || campoCategoria.getText() != null)
				&& (!campoNome.getText().isEmpty() || campoNome.getText() != null)
				&& (!campoFabricante.getText().isEmpty() || campoFabricante.getText() != null)
				&& (!campoCategoria.getText().isEmpty() || campoCategoria.getText() != null)
				&& (!campoFormula.getText().isEmpty() || campoFormula.getText() != null)
				&& (!campoQuantidade.getText().isEmpty() || campoQuantidade.getText() != null)
				&& (!campoPreco.getText().isEmpty() || campoQuantidade.getText() != null)) {
			boolean isValid = false;

			try {
				isValid = validaProduto(preco, quantidade);
				estoque.add(new ProdutoEstoque(new SimpleStringProperty(campoCodigo.getText()),
						new SimpleStringProperty(campoNome.getText()),
						new SimpleStringProperty(campoFabricante.getText()),
						new SimpleStringProperty(campoCategoria.getText()),
						new SimpleStringProperty(campoFormula.getText()),
						new SimpleDoubleProperty(Double.parseDouble(campoPreco.getText())),
						new SimpleIntegerProperty(Integer.parseInt(campoQuantidade.getText()))));
			} catch (NegativePriceException exception) {
				System.out.println("isValid = " + isValid);
				System.out.println("Preco = " + preco);
				throw new InvalidProductException(exception);
			} catch (NegativeAmountException exception) {
				System.out.println("isValid = " + isValid);
				System.out.println("Quantidade = " + quantidade);
				throw new InvalidProductException(exception);
			} finally {
				campoCodigo.clear();
				campoNome.clear();
				campoFabricante.clear();
				campoCategoria.clear();
				campoFormula.clear();
				campoQuantidade.clear();
				campoPreco.clear();
			}
		}
	}

	public static boolean validaProduto(double preco, int quantidade)
			throws NegativePriceException, NegativeAmountException {
		if (preco < 0) {
			throw new NegativePriceException("Price can't be negative");
		}

		else if (quantidade < 0) {
			throw new NegativeAmountException("Amount can't be negative");
		}

		else {
			return true;
		}
	}
}
