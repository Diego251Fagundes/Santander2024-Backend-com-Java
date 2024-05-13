package condicoes;
import java.util.Scanner;
public class SimulacaoBancaria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        double saldo = 0; 

        while (true) {
            System.out.println("Escolha uma opção digitando o número correspondente:\n");
            System.out.println("1. Depositar \n2. Sacar \n3. Consultar saldo \n0. Encerrar \n");
            
            int opcao = scanner.nextInt();
            
            switch (opcao){
                case 1:{
                    System.out.println("Insira o valor que vai ser depositado: ");
                    double valorDepositado= scanner.nextDouble();
                    if(valorDepositado>0){
                        saldo = saldo + valorDepositado;
                        System.out.println("Saldo Atual: R$" + saldo);    
                    } else{
                        System.out.println("o valor a ser depositado tem que ser maior que 0.");
                    }
                    break;
                }
                case 2:{
                    System.out.println("Informe o valor a ser sacado: ");
                    double valorSaque = scanner.nextDouble();
                    if(saldo>valorSaque){
                        saldo = saldo - valorSaque;
                        System.out.println("Operação de saque aprovada retire o seu dinheiro: " + valorSaque);
                        System.out.println("Saldo Atual: R$" + saldo);
                    } else{
                        System.out.println("Saldo insuficiente");
                    }
                    break;
                }
                case 3:{
                    System.out.println("Saldo atual: R$" + saldo);
                    break;
                }
                case 0:{
                    System.out.println("Progama Encerrado");
                    scanner.close();
                    return;
                    
                }
                default:
                    System.out.println("Opção inválida. Tente novamente");
            }    
        }
    }    
}