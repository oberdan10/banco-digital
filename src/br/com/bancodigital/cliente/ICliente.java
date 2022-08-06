package br.com.bancodigital.cliente;

import br.com.bancodigital.banco.Banco;

public interface ICliente {
    void CadastrarCliente(Cliente cliente, Banco banco);
}
