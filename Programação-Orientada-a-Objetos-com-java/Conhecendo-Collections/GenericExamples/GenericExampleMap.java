import java.util.HashMap;
import java.util.Map;

public class GenericExampleMap {
    public static void main(String[] args) {
        //Exenplo sem Generics
        Map mapaSemGenerics = new HashMap();
        mapaSemGenerics.put("Chave 1",10);
        mapaSemGenerics.put("Chave 2", "Valor"); //Permite adicionar qualquer tipo de objeto

        //Exemplo com Generics
        Map<String, Integer> mapaGenerics = new HashMap<>();
        mapaGenerics.put("chave 1", 10);
        mapaGenerics.put("Chave 2", 20);

        //Iterando sobre o mapa com Generics
        for (Map.Entry<String, Integer> entry : mapaGenerics.entrySet()){
            String chave = entry.getKey();
            int valor = entry.getValue();
            System.out.println("Chave: " + chave + ", Valor: " + valor);
        }

        // Interando sobre o mapa sem Generics (Necessário fazer cast)
        for (Object obj : mapaSemGenerics.entrySet()){
            Map.Entry entry  = (Map.Entry) obj;
            String chave = (String) entry.getKey();
            Object valor = entry.getValue();
            System.out.println("Chave: " + chave +", Valor: " + valor);
        }
    }
}