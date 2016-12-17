
package classes;
import javax.swing.JOptionPane;

public class Aluno {
    private int numMatricula,frequencia, aulas;
    private float nota1,nota2,nota3;
  
    
    
    public Aluno(){
        
        this.frequencia = 0;
        this.nota1 = 0;
        this.nota2 = 0;
        this.nota3 = 0;
        this.numMatricula = 0;
        this.aulas= 0;
    }
    
    public Aluno(int numMatricula, int frequencia,int aulas, float nota1, float nota2, float nota3, Controle control){
                
        setNota1(nota1);
        setNota2(nota2);
        setNota3(nota3);
        setFrequencia(frequencia);
        setNumMatricula(numMatricula, control);
        setAulas(aulas);
        
    }
    
    public int getAulas(){
        return aulas;
    }
    
    public void setAulas(int aula){
        boolean sai; 
        do{
            sai = false;
           if(aula >0) this.aulas = aula;
           else{
                JOptionPane.showMessageDialog(null, "Numero de aluas esta errado");
                aula = Integer.parseInt(JOptionPane.showInputDialog("Digite novamente o numero de alunas"));
                sai = true;
           }
        }while(sai);
    }
    public int getNumMatricula() {
        return numMatricula;
    }
    
    

    public void setNumMatricula(int numMatricula, Controle control) {
             boolean sai; 
             
            do{       
                sai = false;
               if(numMatricula>=0 && control.validacao(numMatricula)){
                   this.numMatricula = numMatricula;
                   
               }
               else{
                   JOptionPane.showMessageDialog(null, "Numero de matricula ja existente");
               numMatricula = Integer.parseInt(JOptionPane.showInputDialog("Digite novamente o numero da matricula do aluno"));
               sai = true;
              }
               
             }while(sai);
       }

    public int getFrequencia() {
        return this.frequencia;
    }

    public void setFrequencia(int frequencia) {
        boolean sai; 
        do{
            sai = false;
           if(frequencia >=0 && frequencia <=100) this.frequencia = frequencia;
           else{
                JOptionPane.showMessageDialog(null, "Numero de frequencia esta errado");
                frequencia = Integer.parseInt(JOptionPane.showInputDialog("Digite novamente a frequencia do aluno"));
                sai = true;
           }
        }while(sai);
    }

    public float getNota1() {
        return nota1;
    }

    public void setNota1(float nota1) {
        boolean sai; 
        do{  
             sai = false;
              if (nota1 >=0 && nota1<=10)this.nota1 = nota1;
              else{
                  JOptionPane.showMessageDialog(null, "Nota da primeira prova inconsistente");
                nota1 =  Float.parseFloat(JOptionPane.showInputDialog("Digite novamente a primeira nota do aluno"));
                sai = true;
              }
              
        }while(sai);
      
        
    }

    public float getNota2() {
        return nota2;
    }

    public void setNota2(float nota2) {
        
        boolean sai; 
        do{  
             sai = false;
             if (nota2 >=0 && nota2<=10) this.nota2 = nota2;
              else{
                  JOptionPane.showMessageDialog(null, "Nota da segunda prova inconsistente");
                nota2 =  Float.parseFloat(JOptionPane.showInputDialog("Digite novamente a segunda nota do aluno"));
                sai = true;
              }
              
        }while(sai);
    }

    public float getNota3() {
        return nota3;
    }

    public void setNota3(float nota3) {
       
       boolean sai; 
        do{  
             sai = false;
             if(nota3 >= 0 && nota3<=10) this.nota3 = nota3;
              else{
                  JOptionPane.showMessageDialog(null, "Nota da terceira prova inconsistente");
                nota3 =  Float.parseFloat(JOptionPane.showInputDialog("Digite novamente a terceira nota do aluno"));
                sai = true;
              }
              
        }while(sai);
    } 
    
    public float  maiorNota(){
         
        float maior = nota1;
        
        if(nota2 > maior){
            if(nota2 > nota3){
                maior = nota2;
            }
            
        }
        if(nota3 > maior){
            if(nota3 > nota2){
                 maior = nota3;
            }           
        }        
        return maior;
    }
    
    public float menorNota(){
        
        float maior = nota1;
        
        if(nota2 < maior){
            if(nota2 < nota3){
                return nota2;
            }
            
        }
        if(nota3 < maior){
            if(nota3 < nota2){
                return  nota3;
            }           
        }        
        return maior;
    }
    
    public float NotaFinal(){
        return (nota1+nota2+nota3)/3;
    }
    
    public boolean  resultado(){
        return (NotaFinal() >= 6) && !reprovadosPorFalta();
           
    }
    
    public boolean reprovadosPorFalta(){
        return (getFrequencia()*100)/this.aulas < 75;
    }
    
}
