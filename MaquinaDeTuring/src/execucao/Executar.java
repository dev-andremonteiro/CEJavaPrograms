package execucao;

import conceito.entrada.Entrada;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Executar {

    public static void main(String[] args) throws FileNotFoundException {
        String result = null;
        char leitura;
        int x = 0;
        
        Entrada ent = new Entrada();
        
        do{
            x++;
            try{
                leitura = (ent.getEstado()).getFita().lerFita(ent.getEstado().getCabeca());
                result = ent.getEstado().processarEstado("Q0", leitura);
            }catch(ArrayIndexOutOfBoundsException ex){
                result = "CARACTER_INVALIDO";    
            }
            System.out.println(x+" --- "+result);
            
        }while(result != "CARACTER_INVALIDO");
        
        
    }
    
}
