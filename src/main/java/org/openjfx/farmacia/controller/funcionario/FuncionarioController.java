package org.openjfx.farmacia.controller.funcionario;

public class FuncionarioController implements Controller {
	private static int quantidadeDeFuncionarios;
	
	public FuncionarioController() {
		setQuantidadeDeFuncionarios(1);
	}
	
	@Override
	public void contratarFuncionario(String nome, String cpf, int idade) {
		Funcionario funcionario = cadastrarAtendente(nome, cpf, idade);
	}
	
	private Atendente cadastrarAtendente(String nome, String cpf, int idade) {
		return new Atendente(nome, cpf, idade);
	}
	
	@Override
	public void demitirFuncionario(Funcionario funcionario) {};
	
	@Override
	public void obterFolhaDePagamento() {
		// 
	};
	
	public void obterFolhaDePagamento(Funcionario funcionario) {};
	
	public static int getQuantidadeDeFuncionarios() {
		return quantidadeDeFuncionarios;
	}

	public static void setQuantidadeDeFuncionarios(int quantidadeDeFuncionarios) {
		
		FuncionarioController.quantidadeDeFuncionarios = quantidadeDeFuncionarios;
	}
}
