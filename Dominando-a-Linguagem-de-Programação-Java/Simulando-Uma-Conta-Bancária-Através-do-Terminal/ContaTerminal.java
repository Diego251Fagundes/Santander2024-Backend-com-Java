import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite seu nome: ");
        String nomeCliente = scanner.next();
        
        System.out.println("Digite o número da agência: ");
        String agencia = scanner.next();
        
        System.out.println("Digite o número da conta: ");
        int conta = scanner.nextInt();
        
        System.out.println("Digite seu saldo: ");
        double saldo = scanner.nextDouble();
        
        Usuario u1;
        u1 = new Usuario(nomeCliente, conta, agencia,saldo);

        System.out.println("Olá " + u1.getNomeCliente() + ", obrigado por criar uma conta em nosso banco, sua agência é "
        + u1.getAgencia() + ", conta " + u1.getNumero() + " e seu saldo de " + u1.getSaldo() + "R$ já está disponivel para saque") ;      
    }
}