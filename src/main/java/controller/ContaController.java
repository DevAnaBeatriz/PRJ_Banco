/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ana Beatriz
 */
package controller;

import model.ContaBancaria;
import view.ContaView;

import java.util.ArrayList;
import java.util.List;

// essa classe faz parte do padrão de arquitetura MVC (Model-View-Controller).
// o controlador (ContaController) faz a ponte entre a model (dados) e a view (interface do usuário).
public class ContaController {
    
    // atributo: uma lista que armazena todas as contas bancárias cadastradas.
    private List<ContaBancaria> contas;
    
    // atributo: referência para a view, que é responsável por exibir as informações ao usuário.
    private ContaView view;

    // construtor: inicializa a lista de contas e recebe a view como parâmetro.
    public ContaController(ContaView view) {
        this.contas = new ArrayList<>();
        this.view = view;
    }

    // método: responsável por adicionar uma nova conta à lista.
    public void adicionarConta(ContaBancaria conta) {
        contas.add(conta);
        System.out.println("Conta adicionada com sucesso: " + conta.getTitular());
    }

    // método: exibe todas as contas cadastradas.
    public void listarContas() {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
            return;
        }
        for (ContaBancaria conta : contas) {
            view.mostrarDetalhesConta(conta.getTitular(), conta.getSaldo());
        }
    }

    // método: permite atualizar o saldo de uma conta com base no nome do titular.
    public boolean atualizarConta(String titular, double novoSaldo) {
        for (ContaBancaria conta : contas) {
            if (conta.getTitular().equalsIgnoreCase(titular)) {
                conta.depositar(novoSaldo - conta.getSaldo()); // ajusta o saldo da conta
                System.out.println("Saldo atualizado para: " + novoSaldo);
                return true;
            }
        }
        System.out.println("Conta não encontrada.");
        return false;
    }

    // método: remove uma conta da lista com base no nome do titular.
    public boolean removerConta(String titular) {
        return contas.removeIf(conta -> conta.getTitular().equalsIgnoreCase(titular));
    }

    // método: realiza um depósito em uma conta existente.
    public void depositar(String titular, double valor) {
        for (ContaBancaria conta : contas) {
            if (conta.getTitular().equalsIgnoreCase(titular)) {
                conta.depositar(valor);
                System.out.println("Depósito realizado para: " + titular);
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }

    // método: realiza um saque em uma conta existente, verificando se há saldo suficiente.
    public void sacar(String titular, double valor) {
        for (ContaBancaria conta : contas) {
            if (conta.getTitular().equalsIgnoreCase(titular)) {
                if (conta.sacar(valor)) {
                    System.out.println("Saque realizado com sucesso.");
                } else {
                    System.out.println("Saldo insuficiente.");
                }
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }
}
