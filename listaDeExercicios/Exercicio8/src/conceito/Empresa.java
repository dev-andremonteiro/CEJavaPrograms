
package conceito;

import java.util.ArrayList;

public class Empresa {
    
    ArrayList<Candidato> candidatos;
    
    public Empresa(){
        candidatos = new ArrayList<Candidato>();
    }
    
    public void addCandidato(Candidato can){
        this.candidatos.add(can);
    }
    
    public int numFeminino(){
        int fem = 0;
        
        for(Candidato temp: this.candidatos){
            if(temp.getSexo() == Sexo.FEMININO){
                fem++;
            }
            
        }
        return fem;
    }
    
    public int numMasculino(){
        int mas = 0;
        
        for(Candidato temp: this.candidatos){
            if(temp.getSexo() == Sexo.MASCULINO){
                mas++;
            }
            
        }
        return mas;
    }
    
    
    public int menorIdadeFemininoExp(){
        int menorfem = 99999;
        
        for(Candidato temp: this.candidatos){
            if(temp.getSexo() == Sexo.FEMININO){
                if(temp.isExp()){
                    if(temp.getIdade() < menorfem){
                        menorfem = temp.getIdade();
                    }
                }
            }
            
        }
        if(menorfem != 99999)return menorfem;
        return 0;
    }
    

    public int mediaMasculinoExp(){
        float mediaME = 0,adc = 0;
        
        for(Candidato temp: this.candidatos){
            if(temp.getSexo() == Sexo.MASCULINO){
                if(temp.isExp()){
                    mediaME = mediaME + temp.getIdade();
                    adc++;
                }
            }
            
        }
        if(adc != 0)mediaME = mediaME/adc;
        
        return (int)mediaME;
    }
    
    
    public int porcMasculino45(){
        float porcM45 = 0;
        
        for(Candidato temp: this.candidatos){
            if(temp.getSexo() == Sexo.MASCULINO){
                if(temp.getIdade() > 45){
                    porcM45++;
                }
            }
            
        }
        
        porcM45 = porcM45/(this.candidatos.size());
        porcM45 = porcM45 * 100;
        return (int)porcM45;
    }
    
    public int porcFeminino35(){
        float porcF35 = 0;
        
        for(Candidato temp: this.candidatos){
            if(temp.getSexo() == Sexo.FEMININO){
                if(temp.getIdade() < 35){
                    if(temp.isExp()){
                        porcF35++;
                    }
                }
            }
            
        }
        
        porcF35 = porcF35/(this.candidatos.size());
        porcF35 = porcF35 * 100;
        return (int)porcF35;
    }
    
    public String relatorio(){
        return ("-------Relatório-------\nNumero de Cadidatas: "+numFeminino()+".\nNumero de Candidatos: "+numMasculino()+".\nIdade media de Homens com experiência: "+mediaMasculinoExp()+".\nPorcentagem de Homens com mais de 45: "+porcMasculino45()+".\nPorcentagem de Mulheres com menos de 35 e com experiência: "+porcFeminino35()+".\nMenor idade entre as mulheres com experiência: "+menorIdadeFemininoExp()+".\n-----------------------");
    }
    
}
