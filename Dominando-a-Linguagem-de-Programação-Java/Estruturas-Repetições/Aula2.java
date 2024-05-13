package repeticao;
//For em Arrays
public class Aula2 {
    public static void main(String[] args) {
        //em arrays o indice de elementos inicia em 0
        String alunos[] = {"Neymar" , "Cristiano Ronaldo", "Vini Junior", "Rodrigo"};

        for (int x=0; x<alunos.length; x++){
            System.out.println("O aluno no indice x= " + x + " é " + alunos[x]);
        }
    }
}