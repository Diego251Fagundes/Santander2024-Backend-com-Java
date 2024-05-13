package repeticao;
//break e continue 
public class Aula3 {
    public static void main(String[] args) {
        for(int numero = 1; numero <=5; numero++){
            if(numero==3)
                    break; //em vez do for ir até o 5 ele vai interromper no 2

            System.out.println(numero);
        }        
    }
}