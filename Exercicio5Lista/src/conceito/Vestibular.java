
package conceito;

import java.util.ArrayList;

public class Vestibular {
    
    ArrayList<Curso> cursos;
    
    public Vestibular(){
        cursos = new ArrayList<Curso>();
    }
    
    public void addCursos(Curso cur1){
        this.cursos.add(cur1);
    }
    
    public String totalCandidatos(){
        int x = 0;
        for(Curso temp:this.cursos){
            x = temp.numeroCandidatos() + x;
        }
        return ("Total de Candidatos:"+x+".");
    }
    
    public String maiorNumeroCandidatosVaga(){
        int maior=0;
        int maiorcodigo = 0;
        
        for(Curso temp:this.cursos){
            if(temp.candidatosVaga() > maior){
                maior = temp.candidatosVaga();
                maiorcodigo = temp.getCódigo();
            }
        }
        
        String ret = "Código Curso:"+maiorcodigo+".\nCandidatos por Vaga:"+maior+".";
        return ret;
    }
    
    
    public String relatorio(){
        String rel = "";
        
        for(Curso temp:this.cursos){
            
            rel = rel +"\n\n"+ temp.porcSexo();
            
        }
        
        rel = rel +"\n\n"+ maiorNumeroCandidatosVaga() +"\n"+ totalCandidatos();
        
        return rel;    
    }
    
}
