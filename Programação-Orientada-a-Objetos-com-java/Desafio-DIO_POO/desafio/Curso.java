package desafio;

public class Curso extends Conteudo{
    //Atributos
    private int cargaHoraria;

    //Construtor
    public Curso() {
    }

    //Métodos de acesso
    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;

    }
    
    public String toString() {
        return "Curso[" +
                "titulo='" + getTitulo() + '\'' +
                 ", descricao='" + getDescricao() + '\'' +
                 ", cargaHoraria=" + cargaHoraria + 
                 ']';
    }

}