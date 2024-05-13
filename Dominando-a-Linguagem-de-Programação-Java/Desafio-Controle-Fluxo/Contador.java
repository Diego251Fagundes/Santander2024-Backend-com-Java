import java.util.Scanner;
public class Contador {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o primeiro parâmetro: ");
        int parametroUm = scanner.nextInt();
        System.out.println("Digite o segundo parâmetro: ");
        int parametroDois = scanner.nextInt();
        scanner.close();
        
        try{
            contar(parametroUm, parametroDois);
        }catch (ParametrosInvalidosException e){
            System.out.println(e.getMessage());
        }
    }
    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException{
        if(parametroUm>parametroDois){
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");        
        }
        int contagem = parametroDois-parametroUm;
        for(int x =1;  x<=contagem; x++){
            System.out.println("Imprimindo o Número " + x);
        }
    }
}