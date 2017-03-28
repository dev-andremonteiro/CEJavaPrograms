
package conceito;

import java.util.ArrayList;

public class Curso {
    private String nome;
    private int código;
    private int numeroVagas;
    ArrayList<Candidato> candidatos;
    
    public Curso(){
        this.candidatos = new ArrayList<Candidato>();
    }
    
    public Curso(int código,int numeroVagas){
        this.candidatos = new ArrayList<Candidato>();
        this.código = código;
        this.numeroVagas = numeroVagas;
    }
    
    public void addCandidato(Candidato can1){
        this.candidatos.add(can1);
    }
    
    public void addVariosCandidatosM(int x){
        int y;
        Candidato can1;
        
        for(y=x;y>0;y--){
            can1 = new Candidato();
            can1.setSexo(Sexo.MASCULINO);
            addCandidato(can1);
        }
        
    }
    
    public void addVariosCandidatosF(int x){
        int y;
        Candidato can1;
        
        for(y=x;y>0;y--){
            can1 = new Candidato();
            can1.setSexo(Sexo.FEMININO);
            addCandidato(can1);
        }
        
    }
    
    public int numeroCandidatos(){
        return(this.candidatos.size());
    }
    
    public int sexoCandidatos(){
        int fem=0;
        
        for(Candidato temp:this.candidatos){
            if(temp.getSexo() == Sexo.FEMININO){
                fem++;
            }
        }
        return fem;
    }
    
    public int candidatosVaga(){
        int x = numeroCandidatos();
            x = x/getNumeroVagas();
        return (x);
    }
    
    public String porcSexo(){
        float porc = 0;
              porc = (sexoCandidatos());
              porc = porc/numeroCandidatos();
              porc = porc*100;
        String ret = "Código:"+getCódigo()+"\nMasculino:"+((-1)*(porc-100))+".\nFeminino:"+porc+".";
        
        return ret;
    }
    
    public int getNumeroVagas() {
        return numeroVagas;
    }

    public void setNumeroVagas(int numeroVagas) {
        this.numeroVagas = numeroVagas;
    }

    public int getCódigo() {
        return código;
    }

    public void setCódigo(int código) {
        this.código = código;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
