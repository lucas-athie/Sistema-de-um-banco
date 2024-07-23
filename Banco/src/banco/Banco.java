
package banco;
import java.util.Scanner;
import java.util.Random;

public class Banco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        
        String nome;
        double inicial;
        Scanner entrada = new Scanner(System.in);
        Random numero = new Random();
        int conta = 1 + numero.nextInt(9999);
    
        //Obtendo os dados iniciais do Cliente
        System.out.println("Cadastrando novo cliente.");
        System.out.print("Entre com seu nome: ");
        nome = entrada.nextLine();
        
        System.out.print("Entre com o valor inicial depositado na conta: ");
        inicial = entrada.nextDouble();
        
        //Criando a conta de um cliente
        Cliente meuCliente = new Cliente(nome, conta, inicial);
        meuCliente.iniciar();
        
    }
    
}
