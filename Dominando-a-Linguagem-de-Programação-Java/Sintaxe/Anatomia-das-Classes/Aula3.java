package anatomiadeclasses;
public class Aula3 {
    
    public static void main(String[] args){
        String primeiroNome = "Neymar";
        String segundoNome = "Junior";
        String nomeCompleto = nomeCompleto(primeiroNome,segundoNome);
        System.out.println(nomeCompleto);
    }
    public static String nomeCompleto(String primeiroNome, String segundoNome){
        return "Resultado do Método: " +  primeiroNome.concat(" ").concat(segundoNome);
        
    }
}

