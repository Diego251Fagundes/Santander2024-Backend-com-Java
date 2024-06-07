package desafio;

import java.time.LocalDate;

public class Mentoria extends Conteudo {

    private LocalDate data;

    //Constutor
    public Mentoria(){
    }
    
    //Métodos de acesso
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    
    public double calcularXp() {
       return XP_PADRAO + 20d;
    }

    public String toString() {
        return "Curso[" +
                "titulo='" + getTitulo() + '\'' +
                 ", descricao='" + getDescricao() + '\'' +
                 ", data=" + data + 
                 ']';
    }

}