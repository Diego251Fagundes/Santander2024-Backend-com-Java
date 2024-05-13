package Tiposevariaveis;

//Apenas Exemplos de tipos de variaveis
public class Aula1 {
    public static void main(String[] args) {
        String nome = "Neymar";
        double salarioMinimo = 2500;
    
        short numeroCurto = 1;
        int numeroNormal = numeroCurto;
        short numeroCurto2 = (short) numeroNormal;

       
        //Posso atualizar o valor de uma variável
        int numero = 5;
        numero = 10;
        System.out.println(numero);
        
        //Final indica que é um valor constante e não pode ser mudado
        //Por convenção, constantes são sempre escritas em caixa alta

        final double VALOR_DE_PI = 3.14;

        //VALOR_DE_PI = 3.15; //está linha apresenta um erro pois seu valor não pode ser alterado 
    }  
}
