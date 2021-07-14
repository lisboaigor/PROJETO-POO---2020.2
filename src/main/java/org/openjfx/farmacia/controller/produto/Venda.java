package org.openjfx.farmacia.controller.produto;

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

    public SimpleStringProperty cpfProperty() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf.set(cpf);
    }

    public String getNomeCliente() {
        return nomeCliente.get();
    }

    public SimpleStringProperty nomeClienteProperty() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente.set(nomeCliente);
    }

    public String getCodigo() {
        return codigo.get();
    }

    public SimpleStringProperty codigoProperty() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo.set(codigo);
    }

    public String getNomeProduto() {
        return nomeProduto.get();
    }

    public SimpleStringProperty nomeProdutoProperty() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto.set(nomeProduto);
    }

    public String getUnidades() {
        return unidades.get();
    }

    public SimpleStringProperty unidadesProperty() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades.set(unidades);
    }

    public String getPreco() {
        return preco.get();
    }

    public SimpleStringProperty precoProperty() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco.set(preco);
    }

    public String getDataVenda() {
        return dataVenda.get();
    }

    public SimpleStringProperty dataVendaProperty() {
        return dataVenda;
    }

    @Override
    public String toString() {
        return cpf + ";" + nomeCliente + ";" + codigo + ";" + nomeProduto + ";" + unidades + ";" + preco + dataVenda;
    }
}
