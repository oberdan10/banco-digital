package br.com.bancodigital.conta;

import br.com.bancodigital.cliente.Cliente;

import javax.swing.*;

public abstract class Conta implements IConta{
    //Atributos
    //Foi definido uma Agencia Padrão
    protected static final int AGENCIA_PADRAO = 1;

    //Foi definido um sequencial de numeros referente as contas, independe
    // Conta Corrente ou Poupança
    protected static int SEQUENCIAL = 1;
    protected Cliente cliente;
    protected ETipoConta tipoConta;
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected String extrato = "";

    //Construtor
    public Conta() {

    }

    //Getter e Setter
    public int getAgencia() {
        return agencia;
    }
    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public ETipoConta getTipoConta() {
        return tipoConta;
    }
    public void setTipoConta(ETipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    //Funções do Contrato

    @Override
    public void depositar(double valor) {
        this.extrato += "+ Depósito: R$"+valor+"\n";
        this.saldo+=valor;
    }

    @Override
    public void sacar(double valor) {
        if(valor>this.saldo || valor==0){
            JOptionPane.showMessageDialog(null,"Saldo : R$"+this.saldo+"\nNão Foi Possível Realizar Saque!\n Valor do Saque Maior que Saldo ou Saldo Zerado!");
        }else{
            this.extrato += "- Saque: R$ "+valor+"\n";
            this.saldo-=valor;

        }
    }

    @Override
    public void transferir(Conta destinatario, double valor) {
        if(valor>this.saldo || valor==0){
            JOptionPane.showMessageDialog(null,"Saldo : R$"+this.saldo+"\nNão Foi Possível Realizar Transferência!\n Valor da Transferência Maior que Saldo ou Saldo Zerado!");
        }else {
            this.extrato += "= Transferência: R$ " + valor + "\n";
            destinatario.extrato += "= Transferência: R$ " + valor + "\n";
            destinatario.depositar(valor);
            this.sacar(valor);
            JOptionPane.showMessageDialog(null,"Saldo Atualizado!");
        }
    }

    public void exibirExtrato(){
        String cabecaExtrato = this.tipoConta+"\n"+"Titular: "+this.cliente.getNome()+"\nAgência: "+this.agencia+
                " - Número: "+this.numero+"\n\n";
                JOptionPane.showMessageDialog(null,cabecaExtrato+this.extrato+"Total: R$ "+this.saldo+"\n");
    }
}
