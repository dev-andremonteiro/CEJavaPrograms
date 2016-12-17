
package exercicios;

import conceito.Contador2;
import javax.swing.JOptionPane;

public class ExecStatic {

    public static void main(String[] args) {
        
        Contador2 cont1,cont2,cont3;
        String resp;
        
        resp = "-------------antes de instanciar ----------";
        resp += "\n Classe Contador2 - cont = "+Contador2.getCont();
        cont1 = new Contador2();
        resp += "\n----------depois de instanciar ---------";
        resp += "\nClasse Contador2 - Cont = "+Contador2.getCont();
        resp += "\nObjeto cont1 - Cont = "+cont1.getCont();
        
        cont1.zerarCont();
        cont1.zerarValor();
        
        resp += "\n---------depois de zerar --------------";
        resp += "\n Classe Contador2 - Cont = "+Contador2.getCont();
        resp += "\nObjeto Cont 1 - Cont = "+cont1.getCont();
        
    
        JOptionPane.showMessageDialog(null, resp,"Resultados",JOptionPane.INFORMATION_MESSAGE);
    
        System.exit(0);
    }
    
}
