package org.openjfx.farmacia.controller.funcionario;

public final class Gerente extends Funcionario {
	public Gerente() {
		setSalario(5*salarioMinimo);
	}
	
	public Gerente(String nome) {
		setSalario(5*salarioMinimo);
		setNome(nome);
	}
	
	public Gerente(String nome, String cpf) {
		setSalario(5*salarioMinimo);
		setNome(nome);
		setCpf(cpf);
	}
	
	public Gerente(String nome, String cpf, int idade) {
		setSalario(5*salarioMinimo);
		setNome(nome);
		setCpf(cpf);
		setIdade(idade);
	}
	
	@Override
	public float getSalario() {
		return salario;
	}
	
	@Override
	public void setSalario(float salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return getNome() + ";" + getCpf() + ";" + getIdade() + ";" + getSalario();
	}
}