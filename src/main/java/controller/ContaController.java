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

// essa classe faz parte do padrão de arquitetura mvc (model-view-controller).
// o controlador (contacontroller) faz a ponte entre a model (dados) e a view (interface do usuário).
public class ContaController {
    
    // classe: uma classe é um modelo que define um conjunto de atributos e métodos que descrevem um objeto.
    // aqui, a classe contacontroller representa um controlador que gerencia operações bancárias no sistema.
    
    // atributo: um atributo é uma variável que pertence a uma classe e armazena informações sobre um objeto.
    // aqui, "contas" é um atributo que armazena todas as contas cadastradas no sistema.
    private List<ContaBancaria> contas;
    
    // atributo: a variável "view" é um atributo que referencia a interface responsável por exibir as informações ao usuário.
    private ContaView view;

    // construtor: é um método especial que é chamado quando um objeto da classe é criado.
    // aqui, o construtor inicializa a lista de contas e recebe a view como parâmetro.
    public ContaController(ContaView view) {
        this.contas = new ArrayList<>();
        this.view = view;
    }

    // método: um método é uma função definida dentro de uma classe que executa uma ação específica.
    // o método abaixo adiciona uma conta na lista de contas do sistema.
    public void adicionarConta(ContaBancaria conta) {
        contas.add(conta);
        System.out.println("conta adicionada com sucesso: " + conta.getTitular());
    }

    // método: este método exibe todas as contas cadastradas no sistema.
    public void listarContas() {
        if (contas.isEmpty()) {
            System.out.println("nenhuma conta cadastrada.");
            return;
        }
        for (ContaBancaria conta : contas) {
            view.mostrarDetalhesConta(conta.getTitular(), conta.getSaldo());
        }
    }

    // método: este método permite atualizar o saldo de uma conta com base no nome do titular.
    public boolean atualizarConta(String titular, double novoSaldo) {
        for (ContaBancaria conta : contas) {
            if (conta.getTitular().equalsIgnoreCase(titular)) {
                conta.depositar(novoSaldo - conta.getSaldo()); // ajusta o saldo da conta
                System.out.println("saldo atualizado para: " + novoSaldo);
                return true;
            }
        }
        System.out.println("conta não encontrada.");
        return false;
    }

    // método: este método remove uma conta da lista com base no nome do titular.
    public boolean removerConta(String titular) {
        return contas.removeIf(conta -> conta.getTitular().equalsIgnoreCase(titular));
    }

    // método: este método realiza um depósito em uma conta existente.
    public void depositar(String titular, double valor) {
        for (ContaBancaria conta : contas) {
            if (conta.getTitular().equalsIgnoreCase(titular)) {
                conta.depositar(valor);
                System.out.println("depósito realizado para: " + titular);
                return;
            }
        }
        System.out.println("conta não encontrada.");
    }

    // método: este método realiza um saque em uma conta existente, verificando se há saldo suficiente.
    public void sacar(String titular, double valor) {
        for (ContaBancaria conta : contas) {
            if (conta.getTitular().equalsIgnoreCase(titular)) {
                if (conta.sacar(valor)) {
                    System.out.println("saque realizado com sucesso.");
                } else {
                    System.out.println("saldo insuficiente.");
                }
                return;
            }
        }
        System.out.println("conta não encontrada.");
    }
}
