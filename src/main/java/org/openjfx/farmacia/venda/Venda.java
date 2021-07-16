package org.openjfx.farmacia.venda;

import javafx.beans.property.SimpleStringProperty;

public class Venda {
    protected SimpleStringProperty cpf;
    protected SimpleStringProperty nomeCliente;
    protected SimpleStringProperty codigo;
    protected SimpleStringProperty nomeProduto;
    protected SimpleStringProperty unidades;
    protected SimpleStringProperty preco;
    protected SimpleStringProperty dataVenda;

    public Venda(SimpleStringProperty cpf, SimpleStringProperty nomeCliente, SimpleStringProperty codigo, SimpleStringProperty nomeProduto, SimpleStringProperty unidades, SimpleStringProperty preco, SimpleStringProperty dataVenda) {
        this.cpf = cpf;
        this.nomeCliente = nomeCliente;
        this.codigo = codigo;
        this.nomeProduto = nomeProduto;
        this.unidades = unidades;
        this.preco = preco;
        this.dataVenda = dataVenda;
    }

    public String getCpf() {
        return cpf.get();
    }

    public String getNomeCliente() {
        return nomeCliente.get();
    }

    public String getCodigo() {
        return codigo.get();
    }

    public void setCodigo(String codigo) {
        this.codigo.set(codigo);
    }

    public String getNomeProduto() {
        return nomeProduto.get();
    }

    public String getUnidades() {
        return unidades.get();
    }

    public String getPreco() {
        return preco.get();
    }

    public String getDataVenda() {
        return dataVenda.get();
    }

    @Override
    public String toString() {
        return cpf.get() + ";" + nomeCliente.get() + ";" + codigo.get() + ";" + nomeProduto.get() + ";" +
                unidades.get() + ";"+ preco.get() + dataVenda.get();
    }
}
