/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prj_mvc_smalltalk;
import model.ContaPoupanca;
import model.ContaCorrente;
import view.ContaView;
import controller.ContaController;

/**
 *
 * @author Ana Beatriz
 */
public class PRJ_MVC_Smalltalk {

    public static void main(String[] args) {
        // aqui estamos criando a view que será responsável por exibir as informações para o usuário.
        ContaView view = new ContaView();

        // criamos o controller, que gerencia as operações entre a model (dados) e a view.
        ContaController controller = new ContaController(view);

        // objeto: um objeto é uma instância de uma classe, ou seja, é a representação concreta de um conceito definido por uma classe.
        // aqui estamos criando dois objetos do tipo ContaPoupanca e ContaCorrente e armazenando-os na lista de contas do controller.
        
        // CREATE: criando contas bancárias e adicionando ao sistema.
        controller.adicionarConta(new ContaPoupanca("Ana", 1000)); // cria um objeto da classe ContaPoupanca para Ana com saldo inicial de 1000
        controller.adicionarConta(new ContaCorrente("Beatriz", 500)); // cria um objeto da classe ContaCorrente para Beatriz com saldo inicial de 500

        // READ: listando todas as contas cadastradas no sistema.
        System.out.println("\n Contas Cadastradas:");
        controller.listarContas();

        // UPDATE: atualizando o saldo da conta de Ana.
        System.out.println("\n Atualizando saldo da conta de Ana...");
        controller.atualizarConta("Ana", 2000);

        // realizando operações bancárias.
        System.out.println("\n Depositando R$ 300 na conta de Beatriz...");
        controller.depositar("Beatriz", 300); // adiciona 300 reais na conta de Beatriz

        System.out.println("\n Sacando R$ 100 da conta de Ana...");
        controller.sacar("Ana", 100); // retira 100 reais da conta de Ana

        // exibindo contas após as operações realizadas.
        System.out.println("\n Contas Após Atualizações:");
        controller.listarContas();

        // DELETE: removendo uma conta do sistema.
        System.out.println("\n Removendo conta de Beatriz...");
        controller.removerConta("Beatriz");

        // exibindo contas após a remoção.
        System.out.println("\n Contas Após Remoção:");
        controller.listarContas();
    }
}






