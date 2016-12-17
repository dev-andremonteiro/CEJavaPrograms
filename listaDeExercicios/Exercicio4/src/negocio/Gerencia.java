
package negocio;

import java.util.ArrayList;
import classes.Sexo;
import javax.swing.JOptionPane;


public class Gerencia {
    
   
   private ArrayList<Crianca> listaCrianca;
     
   public Gerencia(){
       listaCrianca = new ArrayList<Crianca>();
   }
   
   public void AdicionarCrianca(Crianca cri){
       listaCrianca.add(cri);
   }
   
   public int NumeroTotalDeCriancaNoAno(int ano){
       int aux =0;
       int i = this.listaCrianca.size();
      
       for (Crianca cri : listaCrianca){
           if(cri.getAno() == ano) aux = aux + 1;
       }
       return aux;
   } 
   
   public float PorcentagemDoSexoFeminino(int ano){
       int feminino = 0;
       
       for (Crianca cri : this.listaCrianca){
           if(cri.getAno() == ano){
               if(cri.getSexo() == Sexo.FEMININO){
                   feminino = feminino + 1;
               }
               
           }
       }
       return (feminino * 100)/this.listaCrianca.size();
       
   }
   
   public float PorcentagemDoSexoMasculino(int ano){
       int masculino = 0;
       
       for (Crianca cri : this.listaCrianca){
           if(cri.getAno() == ano){
               if(cri.getSexo() == Sexo.MASCULINO){
                   masculino = masculino + 1;
               }
               
           }
       }
       return (masculino* 100)/this.listaCrianca.size();
       
   }
   
   public float PorcentagemDoSexoMasclinoAcima3kg5(int ano){
       int masc =0;
       
       for( Crianca cri : this.listaCrianca){
           if(cri.getAno()== ano){
               if (cri.getSexo() == Sexo.MASCULINO) {
                    if (cri.getPeso() >= (3.5f)) masc = masc + 1;
               }
            }
       }
       return (masc*100)/this.listaCrianca.size();
   }
   
   public float PorcentagemDoSexoFemininoAcima3kg(int ano){
       int femi =0;
       
       for( Crianca cri : this.listaCrianca){
           if(cri.getAno()== ano){
               if (cri.getSexo() == Sexo.FEMININO) {
                    if (cri.getPeso() >= (3f)) femi = femi + 1;
               }
              
            }
       }
       return (femi*100)/this.listaCrianca.size();
   }
   
   public float PorcentagemDoSexoMasculinoAbaixo2kg5(int ano){
       int mascu = 0;
       for(Crianca cri : this.listaCrianca){
           if(cri.getAno() == ano){
               if(cri.getSexo() == Sexo.MASCULINO){
                   if(cri.getPeso() <= (2.5f)) mascu = mascu + 1;
               }
           }
       }
       return (mascu*100)/this.listaCrianca.size();
   }
   
   public float PorcentagemDoSexoFemininoAbaixo2kg(int ano){
       int femin = 0;
       
       for(Crianca cri : this.listaCrianca){
           if(cri.getAno() == ano){
               if(cri.getSexo() == Sexo.FEMININO){
                   if(cri.getPeso() <= 2) femin = femin + 1;
               }
           }
       }
       return (femin*100)/this.listaCrianca.size();
   }
   
   public void imprimi(int ano){
       JOptionPane.showInputDialog("Dados em relação ao ano de"+ano+"\nPorcentagem de crianças do sexo feminino = "+ this.PorcentagemDoSexoFeminino(ano)+
               "%\nPorcentagem de crianças do sexo masculino "+this.PorcentagemDoSexoMasculino(ano)+"%\nPorcentagem de crianças do sexo masculino acima de 3.5 kg "+
               this.PorcentagemDoSexoMasclinoAcima3kg5(ano)+"%\nPorcentagem de crianças do sexo feminino acima de 3.0 kg "+this.PorcentagemDoSexoFemininoAcima3kg(ano)+
               "%\nPorcentagem de crianças do sexo masculino abaixo de 2.5 kg "+this.PorcentagemDoSexoMasculinoAbaixo2kg5(ano)+"%\nPorcentagem de crianças do sexo feminino abaixo de 2.0 kg "+
               this.PorcentagemDoSexoFemininoAbaixo2kg(ano)+"%");
       
   }
}
