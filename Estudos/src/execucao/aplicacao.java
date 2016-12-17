
package execucao;
import conceito.Aluno;
import conceito.Sexo;
import java.util.*;
import javax.swing.JOptionPane;

public class aplicacao {

    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("André", 20, Sexo.MASCULINO, 6.0f, 7.0f, 8.0f);
        Aluno aluno2 = new Aluno("Lari", 22, Sexo.FEMININO, 5.0f, 9.0f, 10.0f);
        Aluno aluno3 = new Aluno("Daniel", 20, Sexo.MASCULINO, 5.0f, 5.5f, 7.4f);
        
        JOptionPane.showMessageDialog(null, aluno1.aprovado()+aluno2.aprovado()+aluno3.aprovado());
        
    }
    
}
