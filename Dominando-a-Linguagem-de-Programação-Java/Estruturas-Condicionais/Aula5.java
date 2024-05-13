package condicoes;

//Switch case com exemplo em um sistema de medida
public class Aula5 {
    public static void main(String[] args) {
        String sigla = "A";

        switch (sigla){
            case "P":{
                System.out.println("Pequeno");
                break;
            }
            case "M":{
                System.out.println("Médio");
                break;
            }
            case "G":{
                System.out.println("Grande");
                break;
            }
            default:
                System.out.println("Indefinido");
        
        }
        /*
        if(sigla == "P"){
            System.out.println("Pequeno");
        } else if(sigla == "M"){
            System.out.println("Medio");
        } else if(sigla == "G"){
            System.out.println("Grande");
        } else{
            System.out.println("Indefinido");
        }
         * 
         */
        
    }    
}