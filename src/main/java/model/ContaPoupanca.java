/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ana Beatriz
 */
package model;

// herança: é um princípio da programação orientada a objetos onde uma classe pode herdar atributos e métodos de outra classe.
// nesse caso, ContaPoupanca está herdando tudo que a classe ContaBancaria tem, evitando repetição de código.
public class ContaPoupanca extends ContaBancaria {
    
    // atributo estático que define a taxa de rendimento da conta poupança, 5% ao mês.
    private static final double TAXA_RENDIMENTO = 0.05; 

    // construtor: método especial que é chamado quando um objeto da classe é criado.
    // aqui ele recebe o nome do titular e o saldo inicial e repassa para o construtor da classe ContaBancaria usando "super".
    public ContaPoupanca(String titular, double saldoInicial) {
        super(titular, saldoInicial);
    }

    // polimorfismo: é a capacidade de uma classe redefinir um método herdado da classe mãe para se comportar de forma diferente.
    // aqui estamos sobrescrevendo o método aplicarRendimento para que ele tenha um comportamento específico para ContaPoupanca.
    @Override
    public void aplicarRendimento() {
        depositar(getSaldo() * TAXA_RENDIMENTO); // calcula o rendimento da poupança e adiciona ao saldo
    }
}
