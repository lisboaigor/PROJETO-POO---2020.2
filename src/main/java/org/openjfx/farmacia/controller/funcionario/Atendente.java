package org.openjfx.farmacia.controller.funcionario;

public final class Atendente extends Funcionario {	
	public Atendente(String cpf) {
		setCpf(cpf);
	}
	
	public Atendente(String nome, String cpf) {
		setNome(nome);
		setCpf(cpf);
	}
	
	public Atendente(String nome, String cpf, int idade) {
		setNome(nome);
		setCpf(cpf);
		setIdade(idade);
	}
	
	@Override
	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	@Override
	public float getSalario() {
		return salario;
	}	
}