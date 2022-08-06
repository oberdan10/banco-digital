package br.com.bancodigital.banco;

import br.com.bancodigital.cliente.Cliente;
import br.com.bancodigital.conta.Conta;
import br.com.bancodigital.conta.ContaCorrente;
import br.com.bancodigital.conta.ETipoConta;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco implements IBanco{
    protected List<Cliente> clientes = new ArrayList<Cliente>();
    protected List<Conta> contas = new ArrayList<Conta>();

    @Override
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
        JOptionPane.showMessageDialog(null, "Cliente Adicionado no Sistema!");
    }

    @Override
    public void exibirClientes() {
        clientes.toString();
        System.out.println(clientes);
        for (Cliente cliente : clientes
             ) {
            String dados = "\nDados do Cliente: \n"+
                    "Nome: "+cliente.getNome()+
                    "\nCpf: "+cliente.getCpf()+
                    "\nCargo: "+cliente.getCargo();
            System.out.println(dados);
        }
    }

    @Override
    public Cliente buscaCliente(long cpf) {
        for (Cliente cliente : clientes
             ) {
            if(cliente.getCpf() == cpf){
                return cliente;
            }
        }
        return null;
    }

    @Override
    public boolean verificarContaPorCliente(long cpf, ETipoConta tipoConta) {
        for (Conta conta : contas
        ) {
            if(conta.getCliente().getCpf() == cpf && conta.getTipoConta() == tipoConta){
                return false;
            }
        }
        return true;
    }

    @Override
    public Conta buscarConta(long cpf, int agencia, int numero) {
        for (Conta conta : contas
        ) {
            if(conta.getCliente().getCpf() == cpf && conta.getAgencia() == agencia && conta.getNumero() == numero){
                return conta;
            }
        }
        return null;
    }

    @Override
    public void adicionarConta(Conta conta) {
        contas.add(conta);
        JOptionPane.showMessageDialog(null, "Conta Adicionada no Sistema!");
    }

    @Override
    public void atualizarConta(Conta contaAtualiza) {
        for (Conta conta : contas
        ) {
            if(conta.getAgencia() == contaAtualiza.getAgencia() && conta.getNumero() == contaAtualiza.getNumero()){
                contas.set(contas.indexOf(conta), contaAtualiza);
            }
        }
    }

    @Override
    public void exibirContas() {
        contas.toString();
        System.out.println(contas);
        for (Conta contas : contas
        ) {
            String dados = "\nDados do Cliente: \n"+
                    "\nNome: "+contas.getCliente().getNome()+
                    "\nCPF: "+contas.getCliente().getCpf()+
                    "\nAgência: "+ contas.getAgencia()+
                    "\nNúmero: "+contas.getNumero()+
                    "\nSaldo: R$"+contas.getSaldo();
            System.out.println(dados);
        }
    }
}
