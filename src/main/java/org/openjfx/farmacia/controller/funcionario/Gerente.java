package org.openjfx.farmacia.controller.funcionario;

public final class Gerente extends Funcionario {
	public static void gerarRelatorio() {};
	
	public static void contratarFuncionario(Funcionario f) {
		cadastrarFuncionario(f = new Atendente());
	}
	
	private static void cadastrarFuncionario(Funcionario f) {
		
	}
	
	public static void demitirFuncionario(Funcionario f) {
		
	}
}
