/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ana Beatriz
 */
package model;

// herança: a classe ContaCorrente está herdando a classe ContaBancaria, ou seja, ela reutiliza atributos e métodos da classe mãe.
// isso evita repetição de código e permite especializar o comportamento da conta corrente sem precisar reescrever toda a lógica da conta bancária.
public class ContaCorrente extends ContaBancaria {

    // atributo estático que representa a taxa de manutenção da conta corrente. 
    // esse valor é fixo para todas as instâncias da classe.
    private static final double TAXA_MANUTENCAO = 10.0;

    // construtor: método especial chamado quando um objeto da classe ContaCorrente é criado.
    // ele recebe o nome do titular e o saldo inicial e chama o construtor da classe ContaBancaria usando "super".
    public ContaCorrente(String titular, double saldoInicial) {
        super(titular, saldoInicial);
    }

    // polimorfismo: essa classe está sobrescrevendo o método aplicarRendimento da classe mãe.
    // na conta corrente, ao invés de um rendimento positivo, aplicamos uma taxa de manutenção que reduz o saldo.
    @Override
    public void aplicarRendimento() {
        sacar(TAXA_MANUTENCAO); // desconta a taxa mensal da conta corrente
    }
}
