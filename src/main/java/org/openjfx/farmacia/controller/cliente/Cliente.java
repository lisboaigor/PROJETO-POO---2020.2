package org.openjfx.farmacia.controller.cliente;

import java.util.Set;

import org.openjfx.farmacia.controller.Pessoa;

public final class Cliente extends Pessoa {
	private Set<Compra> compras;
	
	public Cliente(String nome) {
		setNome(nome);
	}

	public Cliente(String nome, String cpf) {
		setNome(nome);
		setCpf(cpf);
	}

	public Cliente(String nome, String cpf, int idade) {
		setNome(nome);
		setCpf(cpf);
		setIdade(idade);
	}

	@Override
	public String toString() {
		return nome + ";" + cpf + ";" + idade;
	}
}