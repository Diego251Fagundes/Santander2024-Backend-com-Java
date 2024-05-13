package repeticao;
import java.util.concurrent.ThreadLocalRandom; //valores aleatórios

//While
public class Aula4 {
    public static void main(String[] args) {
        double mesada = 50;
        while(mesada > 0){
            Double valorDoce = valorAleatorio();
            if(valorDoce > mesada)
                valorDoce = mesada;

            System.out.println("Doce do valor: " + valorDoce + " Adicionado no carrinho");
            mesada = mesada - valorDoce;
        }
        System.out.println("Mesada: " + mesada);
        System.out.println("Joãozinho gastou toda a sua mesada em doces");        
    }

    private static double valorAleatorio(){
        return ThreadLocalRandom.current().nextDouble(2,8); //valores aleatórios entre 2 e 8
    }
}