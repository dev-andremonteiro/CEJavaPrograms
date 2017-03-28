
package execucao;

import conceito.Curso;
import conceito.Vestibular;
import conceito.Sexo;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Aplicacao {

    public static void main(String[] args) {
        int sair;
        Vestibular vest = new Vestibular();
        Curso cur;
        
        do{
            cur = new Curso();
            String nome;
            
            nome = JOptionPane.showInputDialog("Digite o nome do curso:");
            cur.setNome(nome);
        
            int num1;
            num1 = (int)Integer.parseInt(JOptionPane.showInputDialog("Forneça o código do curso:"));
            cur.setCódigo(num1);
        
            int num2;
            num2 = (int)Integer.parseInt(JOptionPane.showInputDialog("Forneça o numero de vagas disponiveis:"));
            cur.setNumeroVagas(num2);
                    
            int num3;
            num3 = (int)Integer.parseInt(JOptionPane.showInputDialog("Quantos candidatas do sexo feminino:"));
            cur.addVariosCandidatosF(num3);
                    
            int num4;
            num4 = (int)Integer.parseInt(JOptionPane.showInputDialog("Quantos candidatos do sexo masculino:"));
            cur.addVariosCandidatosM(num4);
                    
            vest.addCursos(cur);
            
            sair = JOptionPane.showConfirmDialog(null, "Deseja fornecer outro curso", "Responda", 
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
        }while(sair == JOptionPane.YES_OPTION);
        
        JOptionPane.showMessageDialog(null, vest.relatorio());
        
        
    }
    
}
