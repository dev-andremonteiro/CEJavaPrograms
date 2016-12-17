package execucao;

import conceito.Cidade;
import conceito.Consumidores;
import javax.swing.JOptionPane;
import conceito.Tipo;
import java.util.InputMismatchException;

public class Aplicacao {

    public static void main(String[] args) {

        int sair=0;
        Cidade cid = new Cidade();
        Consumidores cons;
        try {
            do {
                try {
                    cons = new Consumidores();
                    Tipo tip;
                    tip = (Tipo) JOptionPane.showInputDialog(null, "Escolha o Tipo:", "Escolha",
                            JOptionPane.QUESTION_MESSAGE, null, Tipo.values(), Tipo.values()[0]);
                    cons.setTipo(tip);

                    int num1;
                    num1 = (int) Integer.parseInt(JOptionPane.showInputDialog("Forneça o Consumo(KiloWattH):"));
                    cons.setKilWatt(num1);

                    int num2;
                    num2 = (int) Integer.parseInt(JOptionPane.showInputDialog("Forneça o Numero do Consumidor:"));
                    cons.setNumConsumidor(num2);
                    cid.addConsumidor(cons);

                    sair = JOptionPane.showConfirmDialog(null, "Deseja fornecer dados de outro consumidor", "Responda",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                } catch (InputMismatchException IME) {
                    JOptionPane.showMessageDialog(null, "Valor inconsistente. Por favor refaça o cadastro do produto");
                } catch (NumberFormatException nu) {
                    JOptionPane.showMessageDialog(null, "Por favor insira um valor valido");
                }
            } while (sair == JOptionPane.YES_OPTION);
        } catch (NumberFormatException nu) {
            JOptionPane.showMessageDialog(null, "Por favor insira um valor valido");
        }

        JOptionPane.showMessageDialog(null, cid.relatorio());
        System.exit(0);
    }

}
