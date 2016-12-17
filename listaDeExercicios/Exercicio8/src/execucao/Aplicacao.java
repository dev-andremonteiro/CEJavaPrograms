
package execucao;

import conceito.Candidato;
import conceito.Empresa;
import javax.swing.JOptionPane;
import conceito.Sexo;

public class Aplicacao {
    public static void main(String[] args) {
        
        Empresa emp = new Empresa();
        Candidato can;
        int sair;
        int num1=0;
        int num2=0;
        int exp;
        Sexo sexo;
        
        do{
            can = new Candidato();
            
            num1 = (int) Integer.parseInt(JOptionPane.showInputDialog("Forneça a idade:"));
            can.setIdade(num1);
            num2 = (int) Integer.parseInt(JOptionPane.showInputDialog("Forneça o número do candidato:"));
            can.setNumCandidato(num2);
            exp = (int) JOptionPane.showConfirmDialog(null, "O Candidato tem experiência:");
            if(exp == 0)can.setExp(true);
            else can.setExp(false);
            sexo = (Sexo) JOptionPane.showInputDialog(null, "Forneça o sexo do candidato:","Caixa",JOptionPane.QUESTION_MESSAGE, null,Sexo.values(),Sexo.values()[0]);
            can.setSexo(sexo);
            
            
            emp.addCandidato(can);
            sair = (int) JOptionPane.showConfirmDialog(null, "Deseja Sair:");

        }while(sair == 1);
        
        JOptionPane.showMessageDialog(null, emp.relatorio());
        
    }
}
