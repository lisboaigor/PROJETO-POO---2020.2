package org.openjfx.farmacia.controller.cliente;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public final class Cliente {
    protected SimpleStringProperty cpf;
    protected SimpleStringProperty nome;
    protected SimpleBooleanProperty ativado;

    public Cliente(SimpleStringProperty cpf, SimpleStringProperty nome, SimpleBooleanProperty ativado) {
        this.cpf = cpf;
        this.nome = nome;
        this.ativado = ativado;
    }

    public String getNome() {
        return nome.get();
    }

    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public String getCpf() {
        return cpf.get();
    }

    public SimpleStringProperty cpfProperty() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf.set(cpf);
    }

    public boolean isAtivado() {
        return ativado.get();
    }

    public SimpleBooleanProperty ativadoProperty() {
        return ativado;
    }

    public void setAtivado(boolean ativado) {
        this.ativado.set(ativado);
    }

    @Override
    public String toString() {
        return nome + ";" + cpf + ";" + ativado;
    }


}