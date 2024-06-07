import java.time.LocalDate;

import desafio.Curso;
import desafio.Dev;
import desafio.Mentoria;
import desafio.Bootcamp;
import desafio.Conteudo;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso java");
        curso1.setDescricao("Descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso js");
        curso2.setDescricao("Descrição curso js");
        curso2.setCargaHoraria(4);

        //quando criar esse objeto vai atribuir a data no momento de  criação
        Mentoria mentoria = new Mentoria(); 
        mentoria.setTitulo("Mentoria de java");
        mentoria.setDescricao("Descricao Mentoria Java");
        mentoria.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devDiego = new Dev();
        devDiego.setNome("Diego");
        devDiego.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos Inscritos Diego" + devDiego.getConteudosInscritos());
        System.out.println("Conteudos Concluidos Diego" + devDiego.getConteudosConcluidos());
        

        Dev devJoao = new Dev();
        devJoao.setNome("João");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("\nConteudos Inscritos João" + devJoao.getConteudosInscritos());
        System.out.println("\nConteudos Concluidos  João" + devJoao.getConteudosConcluidos());

    }
}

/*System.out.println(curso1);
System.out.println(curso2);

System.out.println(mentoria);*/