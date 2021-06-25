package org.openjfx.farmacia.controller.funcionario;

import org.openjfx.farmacia.controller.Pessoa;

public abstract class Funcionario extends Pessoa {
	public static float salarioMinimo = 1100;
	protected float salario;
	
	protected abstract float getSalario();
	protected abstract void setSalario(float salario);
}