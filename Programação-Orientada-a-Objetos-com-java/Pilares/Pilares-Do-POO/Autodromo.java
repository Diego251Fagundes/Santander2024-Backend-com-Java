public class Autodromo {
    public static void main(String[] args) {
        Carro jeep = new Carro();
        jeep.setChassi("897897");
        jeep.ligar();

        Moto z400 = new Moto();
        z400.setChassi("467754");
        z400.ligar();
        
        Veiculo coringa = jeep;
        coringa.ligar();
 
       /* o usuario não precisar ver isso então trabalha o encapsulamento
        deixando esses métodos privados
        jeep.confereCambio();
        jeep.confereCombustivel();
        */
    }
}