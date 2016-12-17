package classes;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Controle {
    ArrayList<Aluno> gerencia;
    
    public Controle(){
        gerencia = new ArrayList();
    }
    
    public void adicionar(Aluno aluno){
        gerencia.add(aluno);
   }
    
    public String MaiorNota(){
        Aluno aux = this.gerencia.get(0);
        
        for(Aluno temp: this.gerencia){
            if(temp.maiorNota() > aux.maiorNota()){
                aux = temp;
            }
        }
        return "A maior nota foi de "+aux.maiorNota();
    }
    
    public String MenorNota(){
        Aluno aux = this.gerencia.get(0);
        
        for(Aluno temp: this.gerencia){
            if(temp.menorNota() < aux.menorNota()){
                aux = temp;
            }
        }
         return "A menor nota de "+aux.menorNota();
    }
    
    public float MediaDaTurma(){
        float aux = 0;
        for(Aluno aluno: this.gerencia){
           aux = aux + aluno.NotaFinal();
          }
        return aux;
    }
    
    public int AlunosReprovados(){
        int aux = 0;
        for(Aluno aluno: this.gerencia){
           if(!aluno.resultado()){
               aux +=1;
           }
          }
        return aux;
    }
    
    public float PorcentagemReprovadosPorFalta(){
        int aux = 0;
        for(Aluno aluno: this.gerencia){
           if(aluno.reprovadosPorFalta()){
               aux = aux + 1;
           }
          }
        return (aux*100)/this.gerencia.size();
    }
    
    public boolean validacao(int matricula){
        
         for(Aluno temp: this.gerencia){
            if(matricula == temp.getNumMatricula()){
               return false;
            }
        }
         return true;
         
    }
    
    public void ImprimirTodosOsDadosDosAlunos(){
        
       for(Aluno aluno: this.gerencia){
           
           if(aluno.resultado()){
             JOptionPane.showMessageDialog(null,"O aluno portador do numero de matricula: "+ aluno.getNumMatricula()+
                 "\nTem "+aluno.getFrequencia()*100/aluno.getAulas()+" de frequencia as aulas"+ "\nTem nota final de: "+aluno.NotaFinal()+
                 "\nE está aprovado");
           } else{
               JOptionPane.showMessageDialog(null,"O aluno portador do numero de matricula: "+ aluno.getNumMatricula()+
                 "\nTem "+(aluno.getFrequencia()*100/aluno.getAulas())+" de frequencia as aulas"+ "\nTem nota final de: "+aluno.NotaFinal()+
                 "\nE está reprovado");
           }
        }
       
       JOptionPane.showMessageDialog(null,MaiorNota()+"\n"+ MenorNota()+"\nA media da turma é: "+ MediaDaTurma() 
               +"\nTotal de alunos reprovados: "+ AlunosReprovados()+"\nPorcentagem de alunos reprovados por faltas: "+
               PorcentagemReprovadosPorFalta());
       
       
    }
    
}
