/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;
import java.util.Scanner;
/**
 *
 * @author luska
 */
public class Cliente {
    
    /**
     *
     */
    public static String senha, nome;
    private int conta;
    private double saldo;
    Scanner entrada = new Scanner(System.in);
    
public Cliente (String nome, int conta, double saldo_inicial, String senha){
        this.nome=nome;
        this.senha = senha;
        this.conta=conta;
        saldo=saldo_inicial;

}

    public void extrato(int saques){
        System.out.println("\tEXTRATO");
        System.out.println("Nome: " + this.nome);
        System.out.println("Número da conta: " + this.conta);
        System.out.printf("Saldo atual: %.2f\n",this.saldo);
        System.out.println("Saques realizados hoje: " + saques + "\n");
        
    }
    

    public void sacar(double valor){
        if(saldo >= valor){
            valor *= 100;
            double divisor = 5;
            double resto = Math.floorMod((long) valor, (long) divisor);
            
            //Fazendo a verificação se os valores correspondem as moedas e notas padrões do Brasil
            if(resto == 0){
                valor /= 100;
                saldo -= valor;
                System.out.println("Sacado: " + valor);
                System.out.println("Novo saldo: " + saldo + "\n");

            } else{
                System.out.println("Valor requisitado não possui notas ou moedas correspondentes para o valor total \n");
            }
            
        } else {
            System.out.println("Saldo insuficiente. Faça um depósito\n");
        }
    }
    
    public double getsaldo(){
        return saldo;
    
    }
    
    public void depositar(double valor)
    {
        saldo += valor;
        System.out.println("Depositado: " + valor);
        System.out.println("Novo saldo: " + saldo + "\n");
    }
      
}
