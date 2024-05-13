import java.util.Scanner; 
public class VerificadorNumeroConta { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in);
        String numeroConta = scanner.next();

        try{
            verificarConta(numeroConta);
            System.out.println("Número de conta válido.");
        } 
        catch(IllegalArgumentException e){
            System.out.println("Erro:" + e.getMessage());
        }
        finally{
            scanner.close();
        }
    }

    private static void verificarConta(String numeroConta){
        if(numeroConta.length()!=8){
            throw new IllegalArgumentException("Numero de conta invalido. Digite exatamente 8 digitos.");
        }
    }
}