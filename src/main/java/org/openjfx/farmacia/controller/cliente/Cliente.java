package org.openjfx.farmacia.controller.cliente;

import org.openjfx.farmacia.controller.Pessoa;

public final class Cliente extends Pessoa {
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
	}

	@Override
	public String toString() {
		return nome + ";" + cpf;
	}
	
	
}