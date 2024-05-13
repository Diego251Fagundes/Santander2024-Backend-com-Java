package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto",};
        for (String candidato: candidatos){
            entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do{
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando){
                tentativasRealizadas++;
            }else{
                System.out.println("Contato realizado com sucesso ");
            }
        }while(continuarTentando && tentativasRealizadas<3);
        if(atendeu){
            System.out.println("Conseguimos contato com " + candidato + " Na " + tentativasRealizadas + " Tentativa");
        } else{
            System.out.println("Não conseguimos contato com " + candidato + ", numnero máximo tentativas " + tentativasRealizadas + " Realizada" );
        }
    }   

    //Método auxiliar
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados(){
        String [] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto",};
        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");
        for (int indice = 0; indice <candidatos.length;indice ++){
            System.out.println("o candidato de nº " + (indice+1) + " é " + candidatos[indice]);
        }
        System.out.println("Forma abreviada de interação for each");

        for(String candidato: candidatos){
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }





    static void selecaoCandidatos(){
        String [] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto", "Monica", "Fabricio", "Mirela",
        "Daniela", "Jorge"};
        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;

        while (candidatosSelecionados<5 && candidatosAtual < candidatos.length){
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato(a) " + candidato + " Solicitou este valor de salário R$" + salarioPretendido);
            if(salarioBase >= salarioPretendido){
                System.out.println("O candidato(a) " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800,2200); //Gera um valor aleatório entre 1800 e 2200
    }




    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if (salarioBase> salarioPretendido){
            System.out.println("Ligar para o candidato");
        } else if(salarioBase == salarioPretendido){
            System.out.println("Ligar para o candidato com contra proposta");
        } else{
            System.out.println("Aguardando o resultado dos demais candidatos");
        }
    } 
}