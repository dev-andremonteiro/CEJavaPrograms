package execucao;

import conceito.Cômodo;
import conceito.Residência;
import conceito.Tabela;
import javax.swing.JOptionPane;


public class Aplicacao {

    public static void main(String[] args) {
        
        int sair;
        Residência res1 = new Residência();
        Cômodo com1;
        
        do{
            com1 = new Cômodo();
            Tabela tab;
            tab=(Tabela)JOptionPane.showInputDialog(null, "Escolha o Tipo:", "Escolha", 
                        JOptionPane.QUESTION_MESSAGE, null, Tabela.values(), Tabela.values()[0]);
            com1.setTipo(tab);
        
            int num1;
            num1 = (int)Integer.parseInt(JOptionPane.showInputDialog("Forneça a largura:"));
            com1.setLargura(num1);
        
            int num2;
            num2 = (int)Integer.parseInt(JOptionPane.showInputDialog("Forneça o Comprimento:"));
            com1.setComprimento(num2);
        
            int num3;
            num3 = (int)Integer.parseInt(JOptionPane.showInputDialog("Forneça a potência das lampadas:"));
            com1.setPotência(num3);
                    
            res1.criarCômodo(com1);
            
            sair = JOptionPane.showConfirmDialog(null, "Deseja fornecer dados de outra pessoa", "Responda", 
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
        }while(sair == JOptionPane.YES_OPTION);
        
        
        JOptionPane.showMessageDialog(null, res1.relatorio());
        System.exit(0);
    }
    
}
