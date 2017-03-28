package conceito.entrada;

import conceito.processamento.Estado;
import conceito.processamento.Fita;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;




public class Entrada {
    
    private Estado estado = null;
    String[] entrada = null;

    
    public Entrada(){
        try {
            String ent = "";
            BufferedReader br = new BufferedReader(new FileReader("texto.txt"));
            String comparar = "";
            
            while ((comparar = br.readLine()) != null){
                ent += comparar +'\n';
            } 
            
            System.out.println(ent);
            
            Fita fita = new Fita(ent.toCharArray());
            Estado estado1 = new Estado(fita);
            this.estado = estado1; 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Entrada.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Entrada.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }

    public Estado getEstado() {
        return estado;
    }
    
}
