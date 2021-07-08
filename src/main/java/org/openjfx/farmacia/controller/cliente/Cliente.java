package org.openjfx.farmacia.controller.cliente;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import org.openjfx.farmacia.controller.Pessoa;

public final class Cliente extends Pessoa {

    public Cliente(SimpleStringProperty cpf, SimpleStringProperty nome, SimpleBooleanProperty cadastrado) {
        this.cpf = cpf;
        this.nome = nome;
        this.cadastrado= cadastrado;
    }

    @Override
    public String toString() {
        return nome + ";" + cpf + ";" + cadastrado;
    }


}