package execucao;

import conceito.Cômodo;
import conceito.Residência;
import conceito.Tabela;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;


public class Aplicacao {

    public static void main(String[] args) {
        
        int sair=0;
        Residência res1 = new Residência();
        Cômodo com1;
        com1 = new Cômodo();
        
        try{
            do{
                
                Tabela tab;
                try{
                    tab=(Tabela)JOptionPane.showInputDialog(null, "Escolha o Tipo:", "Escolha", 
                                JOptionPane.QUESTION_MESSAGE, null, Tabela.values(), Tabela.values()[0]);

                    int num1;
                    num1 = (int)Integer.parseInt(JOptionPane.showInputDialog("Forneça a largura:"));

                    int num2;
                    num2 = (int)Integer.parseInt(JOptionPane.showInputDialog("Forneça o Comprimento:"));

                    int num3;
                    num3 = (int)Integer.parseInt(JOptionPane.showInputDialog("Forneça a potência das lampadas:"));
                    
                    
                    com1.setTipo(tab);
                    com1.setLargura(num1);
                    com1.setComprimento(num2);
                    com1.setPotência(num3);
                    res1.criarCômodo(com1);
                    
                    sair = JOptionPane.showConfirmDialog(null, "Deseja fornecer dados de outra pessoa", "Responda", 
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    
                }catch (InputMismatchException IME){
                    JOptionPane.showMessageDialog(null, "Valor inconsistente. Por favor refaça o cadastro do produto");
                }catch(NumberFormatException nu){
                    JOptionPane.showMessageDialog(null, "Por favor insira um valor valido");
                }
                
            }while(sair == JOptionPane.YES_OPTION);
        
        }catch(NumberFormatException nu){
              JOptionPane.showMessageDialog(null, "Por favor insira um valor valido");
        }
        
        
        JOptionPane.showMessageDialog(null, res1.relatorio());
        System.exit(0);
    }
    
}
