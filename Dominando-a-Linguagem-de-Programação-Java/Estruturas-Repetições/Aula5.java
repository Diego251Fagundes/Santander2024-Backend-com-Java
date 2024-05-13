package repeticao;
import java.util.Random;

public class Aula5 {
    public static void main(String[] args) {
        System.out.println("Discando...");

        do{
            //Executando repetidas vezes até alguem atender
            System.out.println("Telefone tocando");
        } while(tocando());
        System.out.println("Alô!");
    }

    public static boolean tocando(){
        boolean atendeu = new Random().nextInt(3)==1;
        System.out.println("Atendeu? " + atendeu);
        return ! atendeu; //nega uma expressão boolean
    }   
}