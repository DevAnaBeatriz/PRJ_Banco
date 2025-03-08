/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ana Beatriz
 */
package model;

// interface: é como um contrato que define métodos que as classes que a implementam precisam ter. 
// nesse caso, qualquer classe que implementar Transacoes vai precisar ter os métodos depositar e sacar.
public interface Transacoes {
    void depositar(double valor); // método que recebe um valor e deve ser implementado por quem usar essa interface
    boolean sacar(double valor); // método que retorna um booleano indicando se o saque foi bem-sucedido ou não
}
