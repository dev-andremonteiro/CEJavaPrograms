
package execucao;

import conceito.Cidade;
import conceito.Consumidores;
import javax.swing.JOptionPane;
import conceito.Tipo;

public class Aplicacao {

    
    public static void main(String[] args) {
        
        int sair;
        Cidade cid = new Cidade();
        Consumidores cons;
        
        do{
            cons = new Consumidores();
            Tipo tip;
            tip=(Tipo)JOptionPane.showInputDialog(null, "Escolha o Tipo:", "Escolha", 
                        JOptionPane.QUESTION_MESSAGE, null, Tipo.values(), Tipo.values()[0]);
            cons.setTipo(tip);
        
            int num1;
            num1 = (int)Integer.parseInt(JOptionPane.showInputDialog("Forneça o Consumo(KiloWattH):"));
            cons.setKilWatt(num1);
        
            int num2;
            num2 = (int)Integer.parseInt(JOptionPane.showInputDialog("Forneça o Numero do Consumidor:"));
            cons.setNumConsumidor(num2);
            cid.addConsumidor(cons);
            
            sair = JOptionPane.showConfirmDialog(null, "Deseja fornecer dados de outro consumidor", "Responda", 
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
        }while(sair == JOptionPane.YES_OPTION);
        
        JOptionPane.showMessageDialog(null, cid.mediaConsumo());
        System.exit(0);
    }
    
}
