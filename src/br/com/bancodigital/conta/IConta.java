package br.com.bancodigital.conta;

import br.com.bancodigital.cliente.Cliente;

public interface IConta {
    //Funções - Contrato com a classe conta,
    //o banco tem duas opções de conta
    //Poupança/Corrente

    void cadastrarConta(Cliente cliente);
    void depositar(double valor);
    void sacar(double valor);
    void transferir(Conta destinatario, double valor);
}
