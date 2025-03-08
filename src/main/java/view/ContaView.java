/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ana Beatriz
 */
package view;

/*
 * esta classe representa a "view" (camada de visualização) no padrão mvc.
 * a view é responsável por exibir informações para o usuário, mas não contém lógica de negócio.
 * 
 * o conceito de interface no mvc refere-se à separação entre a forma como os dados são apresentados 
 * e como eles são processados no sistema. aqui, a interface do usuário (neste caso, um simples console)
 * não precisa saber de onde vêm os dados ou como são manipulados. ela apenas exibe os resultados.
 * 
 * no java, também temos "interfaces" como estruturas da linguagem, que definem um contrato de métodos.
 * esse conceito é utilizado na interface "Transacoes", presente no modelo (model).
 */

public class ContaView {
    // método responsável por exibir os detalhes de uma conta no console
    public void mostrarDetalhesConta(String titular, double saldo) {
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: R$" + saldo);
    }
}
