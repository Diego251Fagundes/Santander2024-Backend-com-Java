package Metodos;

public class Usuario {
    public static void main(String[] args) {
        SistemaTv sistematv = new SistemaTv();

        sistematv.diminuirVolume();
        sistematv.diminuirVolume();
        sistematv.diminuirVolume();
        sistematv.aumentarVolume();

        sistematv.mudarCanal(4);
        

        System.out.println("TV ligada? " + sistematv.ligada);
        System.out.println("Canal atual: " + sistematv.canal);
        System.out.println("Volume atual: " + sistematv.volume);

        sistematv.ligar();
        System.out.println("Novo Status -> TV Ligada? " + sistematv.ligada);

        sistematv.desligar();
        System.out.println("Novo Status -> TV Ligada? " + sistematv.ligada);
    }
}
