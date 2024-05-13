public class Iphone implements ReprodutorMusical, AparelhoTelefonico, NavegadorInternet {
    // ReprodutorMusical
    public void tocar() {
        System.out.println("Tocar música");
    }
    public void pausar() {
        System.out.println("Pausar música");
    }
    public void selecionarMusica(String musica) {
        System.out.println("Selecionando música: " + musica);
    }

    // AparelhoTelefonico
    public void ligar(String numero) {
        System.out.println("\nLigando para " + numero + "...");
    }
    public void atender() {
        System.out.println("Atendendo ligação");
    }
    public void iniciarCorreioVoz() {
        System.out.println("Iniciando correio de voz");
    }

    // NavegadorInternet
    public void exibirPagina(String url) {
        System.out.println("\nExibindo página: " + url);
    }
    public void adicionarNovaAba() {
        System.out.println("Adicionando nova aba...");
    }
    public void atualizarPagina() {
        System.out.println("Atualizando página...");
    }

    public static void main(String[] args) {
        Iphone iphone = new Iphone();
        
        //funcionalidades
        iphone.tocar();
        iphone.pausar();
        iphone.selecionarMusica("numb");
        
        iphone.ligar("959402004");
        iphone.atender();
        iphone.iniciarCorreioVoz();
        
        iphone.exibirPagina("https://www.google.com");
        iphone.adicionarNovaAba();
        iphone.atualizarPagina();
    }
}