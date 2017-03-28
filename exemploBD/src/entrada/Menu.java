
package entrada;

import java.util.Arrays;
import javax.swing.JOptionPane;

public class Menu{
    
    private int entrada;
    private final String texto[] = {"0 - Incluir aluno","1 - Alterar dados do Aluno","2 - Excluir aluno","3 - Pesquisar"};
    private String saida;
    
    public Menu(){
        this.entrada = -1;
    }
    
    public int exibirMenu(){
       
        entrada = Integer.parseInt(JOptionPane.showInputDialog("\t MENU \t"+Arrays.toString(texto)));
        return entrada;
    }
    
    public String getEntrada(String s){
        String sai;
        sai = JOptionPane.showInputDialog(s);
        return sai;
    }
    
    
}
