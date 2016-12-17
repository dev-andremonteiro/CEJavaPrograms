
package entrada;

import java.util.Arrays;
import javax.swing.JOptionPane;

public class Menu{
    
    private int entrada;
    private final String texto[] = {"1 - Pesquisar MATRICULA\n","2 - Pesquisar NOME\n","0 - Incluir aluno\n","1 - Alterar dados do Aluno\n","2 - Excluir aluno\n","3 - Pesquisar\n"};
    private String saida;
    
    public Menu(){
        this.entrada = -1;
    }
    
    public int exibirMenu(boolean par){
        int x = 2;int tamanho = texto.length;
        if(par){
            x=0;
            tamanho = 2;
        }
        String saida = "";
        do{
        saida += texto[x];
        x++;
        }while(x < tamanho);
        
        entrada = Integer.parseInt(JOptionPane.showInputDialog("\t MENU \t\n"+saida));
        
        return entrada;
    }
    
    public String getEntrada(String s){
        String sai;
        sai = JOptionPane.showInputDialog(s);
        return sai;
    }
    
    
}
