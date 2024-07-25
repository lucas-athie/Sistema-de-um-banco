
package banco;
import java.util.Scanner;
import java.util.Random;

public class Banco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        
        String nome = null, nome1 = null, senha = null, senha1;
        double inicial = 0, valor = 0;
        Scanner entrada = new Scanner(System.in);
        Random numero = new Random();
        int conta = 1 + numero.nextInt(9999);
        int opcaologin = 0, opcao = 0, saques = 0;
       
    
        //Obtendo os dados iniciais do Cliente e iniando o loop caso o cliente queira deslogar
        do {
        
            System.out.println("Desaja cadastrar uma conta ou já tem cadastro? \n 1 - Cadastrar \n 2 - Logar\n 3 - Sair");
            opcaologin = entrada.nextInt();
            
            //adicionando um nextLine para armazenar a quebra de linha gerada pelo nextInt
            entrada.nextLine();
            
            //condição referente ao cadastro
            if(opcaologin == 1){
                System.out.println("Cadastrando novo cliente.");
                System.out.print("Entre com seu nome: \n");
                nome = entrada.nextLine();

                System.out.print("Entre com o valor inicial depositado na conta: \n");
                inicial = entrada.nextDouble();
                
                if (inicial < 0){
                    System.out.println("O valor inicial não pode ser negativo");
                    opcao = 4;
                    nome = null;
                    
                }else {
                
                    //adicionando um nextLine para armazenar a quebra de linha gerada pelo nextInt
                    entrada.nextLine();

                    System.out.println("Digite a sua senha: ");
                    senha = entrada.nextLine();

                    System.out.println("Repita a sua senha: ");
                    senha1 = entrada.nextLine();

                    //verificando se as senhas são iguais e caso elas não forem a função if reseta os valores das variáveis
                    if (!senha.equals(senha1)){
                        System.out.println("As senhas digitadas estão diferentes\n");
                        senha = null;
                        senha1 = null;
                        nome = null;
                        inicial= 0;
                        opcao = 4;
                    } else {

                        // caso as senhas sejam iguais, a variavel opcaologin recebe o valor 3 para conseguir sair do loop
                        System.out.println("Cadastrado com sucesso\n");
                        opcaologin = 4;
                        opcao = 0;
                
                    }
                }
            }
            
            //condição do login 
            if (opcaologin == 2){
                
                System.out.println("Entre com seu nome: ");
                nome1 = entrada.nextLine();
            
                System.out.println("Digite a sua senha: ");
                senha = entrada.nextLine();
                
                //verificando se a senha utilizada no cadastro e armazenada na classe Cliente é igual a senha digitada pelo usuário para logar
                if (!senha.equals(Cliente.senha) || !nome1.equals(Cliente.nome)){
                    System.out.println("Senha ou nome não correspondentes\n1");
                    opcao = 4;
                    
                } else{
                    System.out.println("Logado com sucesso\n");
                    opcaologin = 4;
                    opcao = 0;
                }
            }
            if(opcaologin ==3){
                System.out.println("Saindo...");
                opcao =4; 
                opcaologin = 4;
            
            }
            Cliente meuCliente = new Cliente(nome, conta, inicial, senha);
            
           
           //exibição do meneu e swichcase chamando os métodos que estão na classe cliente
           while(opcao!=4) {
               System.out.println("\t Escolha a opção desejada");
               System.out.println("1 - Consultar Extrato");
               System.out.println("2 - Sacar");
               System.out.println("3 - Depositar");
               System.out.println("4 - Sair");
               System.out.println("5 - Deslogar");
               System.out.print("Opção: \n");
               opcao = entrada.nextInt();
               
            
        
            switch( opcao ){
                case 1:    
                        meuCliente.extrato(saques);
                        break;
                case 2: 
                        if(saques<3){
                            System.out.print("Quanto deseja sacar: \n");
                            valor = entrada.nextDouble();
                            meuCliente.sacar(valor);
                            saques++;
                            inicial = meuCliente.getsaldo();
                        } else{
                            System.out.println("Limite de saques diários atingidos.\n");
                        }
                        break;

                case 3:
                        System.out.print("Quanto deseja depositar: \n");
                        valor = entrada.nextDouble();
                        meuCliente.depositar(valor);
                        break;

                case 4: 
                        System.out.println("Sistema encerrado.\n");
                        opcaologin = 4;
                        break;

                case 5:
                    System.out.print("Saindo da conta...\n");
                    opcao = 4;
                    opcaologin = 0;
                    break;

                default:
                        System.out.println("Opção inválida\n");
            }
           
           }

        }while (opcaologin != 4);
       
    }   
}
