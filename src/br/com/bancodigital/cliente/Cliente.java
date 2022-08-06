package br.com.bancodigital.cliente;

import br.com.bancodigital.banco.Banco;

import java.math.BigInteger;

public class Cliente implements ICliente{
    //Atributos
    protected String nome;
    protected long cpf;

    protected String cargo;

    public Cliente() {

    }

    //Getter e Setter
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public long getCpf() {
        return cpf;
    }
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public void CadastrarCliente(Cliente cliente, Banco banco) {
        banco.adicionarCliente(cliente);
    }
//Funções
}
