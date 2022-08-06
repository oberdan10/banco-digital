package br.com.bancodigital.banco;

import br.com.bancodigital.cliente.Cliente;
import br.com.bancodigital.conta.Conta;
import br.com.bancodigital.conta.ETipoConta;

public interface IBanco {
    void adicionarCliente(Cliente cliente);
    void exibirClientes();
    void exibirContas();
    Cliente buscaCliente(long cpf);
    boolean verificarContaPorCliente(long cpf, ETipoConta tipoConta);
    Conta buscarConta(long cpf, int agencia, int numero);
    void adicionarConta(Conta conta);
    void atualizarConta(Conta conta);
}
