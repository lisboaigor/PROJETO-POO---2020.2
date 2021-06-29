package org.openjfx.farmacia.controller.funcionario;

public interface Controller {
	public void contratarFuncionario(String nome, String cpf, int idade);
	public void demitirFuncionario(Funcionario funcionario);
	public void obterFolhaDePagamento();
}
