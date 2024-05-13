package Operadores;

public class Aula5 {
    public static void main(String[] args) {
        int numero1 = 1;
        int numero2 = 2;

        boolean simNao = numero1 == numero2;
        System.out.println("Numero1 é igual a Numero2?: "+ simNao);
        
        simNao = numero1 != numero2;
        System.out.println("Numero1 é diferente de Numero2?: "+ simNao);

        simNao = numero1 > numero2;
        System.out.println("Numero1 é maior que Numero?2: "+ simNao);
    
        if(numero1 < numero2){
            System.out.println("Condição verdadeira");
        }
    }   
}