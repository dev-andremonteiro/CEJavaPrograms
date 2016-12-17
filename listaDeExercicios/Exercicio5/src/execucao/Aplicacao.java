package execucao;

import conceito.Curso;
import conceito.Vestibular;
import conceito.Sexo;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Aplicacao {

    public static void main(String[] args) {
        int sair=0;
        Vestibular vest = new Vestibular();
        Curso cur;
        cur = new Curso();

        try {
            do {
                try{
                String nome;
                nome = JOptionPane.showInputDialog("Digite o nome do curso:");

                int num1;
                num1 = (int) Integer.parseInt(JOptionPane.showInputDialog("Forneça o código do curso:"));

                int num2;
                num2 = (int) Integer.parseInt(JOptionPane.showInputDialog("Forneça o numero de vagas disponiveis:"));

                int num3;
                num3 = (int) Integer.parseInt(JOptionPane.showInputDialog("Quantos candidatas do sexo feminino:"));

                int num4;
                num4 = (int) Integer.parseInt(JOptionPane.showInputDialog("Quantos candidatos do sexo masculino:"));

                cur.setNome(nome);
                cur.setCódigo(num1);
                cur.setNumeroVagas(num2);
                cur.addVariosCandidatosF(num3);
                cur.addVariosCandidatosM(num4);
                vest.addCursos(cur);

                sair = JOptionPane.showConfirmDialog(null, "Deseja fornecer outro curso", "Responda",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            
            }catch (InputMismatchException IME){
                JOptionPane.showMessageDialog(null, "Valor inconsistente. Por favor refaça o cadastro do produto");
            }catch(NumberFormatException nu){
                JOptionPane.showMessageDialog(null, "Por favor insira um valor valido");
            }
        } while (sair == JOptionPane.YES_OPTION);
        } catch (NumberFormatException nu) {
            JOptionPane.showMessageDialog(null, "Por favor insira um valor valido");
        }

        JOptionPane.showMessageDialog(null, vest.relatorio());

    }

}
