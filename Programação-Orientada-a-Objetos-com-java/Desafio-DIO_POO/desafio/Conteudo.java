package desafio;
public abstract class Conteudo {
    //Atributos
    protected static final double XP_PADRAO = 10;
    private String titulo;
    private String descricao;

    //Métodos
    public abstract double calcularXp();

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}