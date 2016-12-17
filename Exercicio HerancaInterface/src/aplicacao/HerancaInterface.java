
package aplicacao;

import conceito.Aluno;
import conceito.ColecaoGenerica;
import conceito.Disciplina;
import conceito.Funcionario;
import conceito.ImprimeColecao;
import conceito.Professor;
import conceito.Turma;


public class HerancaInterface {

 
    public static void main(String[] args) {
        
        Aluno aluno;
        Funcionario fun;
        Professor pro;
        Disciplina dis;
        Turma tur;

        ColecaoGenerica colecaoGenerica = new ColecaoGenerica();
        
        ImprimeColecao relatorio;
        
        aluno = new Aluno();
        aluno.setMatricula(10);
        aluno.setNome("André");
        aluno.setSemestre(6);
        colecaoGenerica.adicionaGenerico(aluno);
        
        fun = new Funcionario();
        fun.setCargo("Professor");
        fun.setMatricula(20);
        fun.setNome("Evandro");
        colecaoGenerica.adicionaGenerico(fun);
        
        pro = new Professor();
        pro.setEspecialidade("Redes");
        pro.setMatricula(30);
        pro.setNome("Edwilson");
        colecaoGenerica.adicionaGenerico(pro);
        
        
        dis= new Disciplina();
        dis.setCodigo(40);
        dis.setNome("Portugues");
        dis.setSemestre(1);
        colecaoGenerica.adicionaGenerico(dis);
        
        tur= new Turma();
        tur.setCodigo(50);
        tur.setNome("Programação");
        colecaoGenerica.adicionaGenerico(tur);


        colecaoGenerica.ordena();
        relatorio = new ImprimeColecao(colecaoGenerica);
        relatorio.imprimir();
        
    }
    
}
