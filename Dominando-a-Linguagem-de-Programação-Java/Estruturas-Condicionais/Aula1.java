package condicoes;

//Condicional Simples
public class Aula1 {
    public static void main(String[] args) {
        double saldo = 25;
        double valorSolicitado = 17.0;

        if(valorSolicitado< saldo){
            saldo = saldo - valorSolicitado;

            System.out.println("Novo saldo: " + saldo);
        }
    }
}