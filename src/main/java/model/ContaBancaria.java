/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Ana Beatriz
 */
package model;

// abstração: essa classe representa um modelo genérico de conta bancária,
// ou seja, uma ideia geral de como funciona uma conta, sem definir detalhes específicos.
public abstract class ContaBancaria {
    
    // encapsulamento: aqui estamos protegendo os dados da conta, tornando os atributos privados.
    // isso significa que só podem ser acessados ou modificados através de métodos específicos.
    private String titular; // nome do dono da conta
    private double saldo;   // valor disponível na conta

    // construtor: sempre que criamos uma nova conta, ele define o titular e o saldo inicial
    public ContaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    // método abstrato (polimorfismo)
    // esse método não tem implementação aqui porque cada tipo de conta pode ter uma forma diferente de rendimento.
    public abstract void aplicarRendimento();

    // métodos (operações)
    
    // depositar um valor na conta
    public void depositar(double valor) {
        saldo += valor; // o valor do saldo aumenta conforme o depósito
    }

    // sacar um valor da conta
    // se o saldo for suficiente, o saque é realizado e retorna true
    // se o saldo for insuficiente, retorna false
    public boolean sacar(double valor) {
        if (valor > saldo) return false; // impede saques maiores que o saldo disponível
        saldo -= valor; // reduz o saldo pelo valor sacado
        return true;
    }

    // getters e setters (encapsulamento)
    // permitem acessar e modificar os dados de maneira controlada
    
    // retorna o nome do titular da conta
    public String getTitular() {
        return titular;
    }
    
    // retorna o saldo atual da conta
    public double getSaldo() {
        return saldo;
    }
}
