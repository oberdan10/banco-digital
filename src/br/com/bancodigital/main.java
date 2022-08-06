package br.com.bancodigital;

import br.com.bancodigital.banco.Banco;
import br.com.bancodigital.cliente.Cliente;
import br.com.bancodigital.conta.Conta;
import br.com.bancodigital.conta.ContaCorrente;
import br.com.bancodigital.conta.ContaPoupanca;
import br.com.bancodigital.conta.ETipoConta;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class main {
    public static void main(String[] args) {
        Banco banco = new Banco();


        boolean deslogarBanco = true;
        int opcao;
        String opcoesBanco = "Bem Vindo, Escolha uma das opções:"
                +"\n 0 - Sair"
                +"\n 1 - Cadastrar Cliente"
                +"\n 2 - Cadastrar Conta Corrente"
                +"\n 3 - Cadastrar Conta Poupança"
                +"\n 4 - Realizar Saque"
                +"\n 5 - Transferência"
                +"\n 6 - Depósito"
                +"\n 7 - Extrato"
                +"\n 8 - Lista de Clientes"
                +"\n 9 - Lista de Contas";

        try {
            while (deslogarBanco == true) {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(opcoesBanco));
                switch (opcao) {
                    case 0:
                        deslogarBanco = false;
                        break;
                    case 1:

                        Cliente cliente = new Cliente();
                        long cpf = Long.parseLong(JOptionPane.showInputDialog("Digite seu CPF: "));
                        cliente = banco.buscaCliente(cpf);

                        if (cliente != null) {
                            JOptionPane.showMessageDialog(null, "Cliente Já Existente no Sistema!");
                        } else {
                            cliente = new Cliente();
                            cliente.setNome(JOptionPane.showInputDialog("Digite seu Nome: "));
                            cliente.setCpf(cpf);
                            cliente.setCargo(JOptionPane.showInputDialog("Digite seu Cargo: "));
                            cliente.CadastrarCliente(cliente, banco);
                        }
                        break;
                    case 2:
                    case 3:
                        cliente = banco.buscaCliente(Long.parseLong(JOptionPane.showInputDialog("Digite seu CPF: ")));
                        if (cliente != null) {
                            if (opcao == 2) {
                                if (banco.verificarContaPorCliente(cliente.getCpf(), ETipoConta.CORRENTE)) {
                                    ContaCorrente conta = new ContaCorrente();
                                    conta.cadastrarConta(cliente);
                                    banco.adicionarConta(conta);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Conta Existente no Sistema!");
                                }
                            } else {
                                if (banco.verificarContaPorCliente(cliente.getCpf(), ETipoConta.POUPANÇA)) {
                                    ContaPoupanca conta = new ContaPoupanca();
                                    conta.cadastrarConta(cliente);
                                    banco.adicionarConta(conta);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Conta Existente no Sistema!");
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Cliente Não Encontrado!");
                        }
                        break;
                    case 4:
                        cpf = Long.parseLong(JOptionPane.showInputDialog("Digite seu CPF: "));
                        int agencia = Integer.parseInt(JOptionPane.showInputDialog("Digite sua Agencia: "));
                        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite seu Número: "));
                        Conta cc = banco.buscarConta(cpf, agencia, numero);
                        if (cc != null) {
                            double saldo = Double.parseDouble(JOptionPane.showInputDialog("Digite o Valor de Saque: "));
                            cc.sacar(saldo);
                            banco.atualizarConta(cc);
                            JOptionPane.showMessageDialog(null, "Saldo Atualizado!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Conta Não Encontrada!");
                        }
                        break;
                    case 5:
                        cpf = Long.parseLong(JOptionPane.showInputDialog("Digite seu CPF: "));
                        agencia = Integer.parseInt(JOptionPane.showInputDialog("Digite sua Agencia: "));
                        numero = Integer.parseInt(JOptionPane.showInputDialog("Digite seu Número: "));

                        long cpfDestinatario = Long.parseLong(JOptionPane.showInputDialog("Digite CPF do Destinatário: "));
                        int agenciaDestinatario = Integer.parseInt(JOptionPane.showInputDialog("Digite a Agencia do Destinatário: "));
                        int numeroDestinatario = Integer.parseInt(JOptionPane.showInputDialog("Digite o Número do Destinatário: "));

                        cc = banco.buscarConta(cpf, agencia, numero);
                        Conta ccd = banco.buscarConta(cpfDestinatario, agenciaDestinatario, numeroDestinatario);

                        if (cc != null && ccd != null) {
                            double saldo = Double.parseDouble(JOptionPane.showInputDialog("Digite o Valor de Transferência: "));
                            cc.transferir(ccd, saldo);
                            banco.atualizarConta(cc);
                            banco.atualizarConta(ccd);
                            JOptionPane.showMessageDialog(null, "Saldo Atualizado!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Conta(s) Não Encontrada(s)!");
                        }
                        break;
                    case 6:
                        cpf = Long.parseLong(JOptionPane.showInputDialog("Digite seu CPF: "));
                        agencia = Integer.parseInt(JOptionPane.showInputDialog("Digite sua Agencia: "));
                        numero = Integer.parseInt(JOptionPane.showInputDialog("Digite seu Número: "));
                        cc = banco.buscarConta(cpf, agencia, numero);
                        if (cc != null) {
                            double saldo = Double.parseDouble(JOptionPane.showInputDialog("Digite seu Depósito: "));
                            cc.depositar(saldo);
                            banco.atualizarConta(cc);
                            JOptionPane.showMessageDialog(null, "Saldo Atualizado!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Conta Não Encontrada!");
                        }
                        break;
                    case 7:
                        cpf = Long.parseLong(JOptionPane.showInputDialog("Digite seu CPF: "));
                        agencia = Integer.parseInt(JOptionPane.showInputDialog("Digite sua Agencia: "));
                        numero = Integer.parseInt(JOptionPane.showInputDialog("Digite seu Número: "));
                        cc = banco.buscarConta(cpf, agencia, numero);
                        if (cc != null) {
                            cc.exibirExtrato();
                            banco.atualizarConta(cc);
                            JOptionPane.showMessageDialog(null, "Saldo Atualizado!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Conta Não Encontrada!");
                        }
                        break;
                    case 8:
                        banco.exibirClientes();
                        break;
                    case 9:
                        banco.exibirContas();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção Não Encontrada!");
                }
            }
        }catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null,"Não Utilizar Letras ou Deixar Campos em Branco em Campos Numéricos!");
        }
        catch (Exception ex) {
            System.out.println(ex);
        }finally {
            JOptionPane.showMessageDialog(null,"Programa Finalizado!");
        }
    }
}
