package org.openjfx.farmacia.controller.funcionario;

public class FuncionarioController implements Controller {
	private static int quantidadeDeFuncionarios;
	
	public FuncionarioController() {
		setQuantidadeDeFuncionarios(1);
	}
	
	public void contratarFuncionario(String nome, String cpf, int idade) {
		Atendente atendente = cadastrarAtendente();
	}
	
	private Atendente cadastrarAtendente() {
		return new Atendente();
	}
	
	@Override
	public void demitirFuncionario(Funcionario funcionario) {};
	
	@Override
	public void obterFolhaDePagamento() {};
	
	public void obterFolhaDePagamento(Funcionario funcionario) {};
	
	public static int getQuantidadeDeFuncionarios() {
		return quantidadeDeFuncionarios;
	}

	public static void setQuantidadeDeFuncionarios(int quantidadeDeFuncionarios) {
		
		FuncionarioController.quantidadeDeFuncionarios = quantidadeDeFuncionarios;
	}
}
