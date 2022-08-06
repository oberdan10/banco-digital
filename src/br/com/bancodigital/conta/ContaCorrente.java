package br.com.bancodigital.conta;

import br.com.bancodigital.cliente.Cliente;

import javax.swing.*;

public class ContaCorrente extends Conta{

    public ContaCorrente() {
    }
    @Override
    public void cadastrarConta(Cliente cliente){
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = Conta.SEQUENCIAL++;
        this.cliente = cliente;
        this.tipoConta = ETipoConta.CORRENTE;
    }
}
