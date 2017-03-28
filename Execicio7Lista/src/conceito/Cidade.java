
package conceito;

import java.util.ArrayList;

public class Cidade {
    
    ArrayList<Consumidores> consumidor;
    
    public Cidade(){
        consumidor = new ArrayList<Consumidores>();
    }
    
    public void addConsumidor(Consumidores cons){
        this.consumidor.add(cons);
    }
    
    public float maiorConsumo(){
        float x=0;
            for(Consumidores temp:this.consumidor){
                x = Float.max(temp.totalAPagar(),x);
            }
        return x;
    }
    
    public float menorConsumo(){
        float x = 99999999;
            for(Consumidores temp:this.consumidor){
                if(temp.totalAPagar() < x){
                    x = temp.totalAPagar();
                }
            }    
        return x;
    }

    public float somaConsumoTipos(Tipo tipo){
        float consumo = 0;
        
        for(Consumidores cons:consumidor){
            
            if(cons.getTipo() == tipo){
                consumo = consumo + cons.getKilWatt();
            }
        }
        return consumo;
    }
    
    public float somaTipos(Tipo tipo){
        float adc = 0;
        
        for(Consumidores cons:consumidor){
            
            if(cons.getTipo() == tipo){
                adc++;
            }
        }
        return adc;
    }
    
    public String totalConsumoTipos(){
        
        return "Comercial:"+somaConsumoTipos(Tipo.COMERCIAL)+"\nResidencial:"
                +somaConsumoTipos(Tipo.RESIDENCIAL)+"\nIndustrial:"
                +somaConsumoTipos(Tipo.INDUSTRIAL)+"\n";
             
    }
    
    public String mediaConsumo(){
        float media=0;
        String ret="";
        
        media = somaConsumoTipos(Tipo.RESIDENCIAL);
        media = media/somaTipos(Tipo.RESIDENCIAL);
        ret = "Media Residencial:"+media;
        
        media = somaConsumoTipos(Tipo.COMERCIAL);
        media = media/somaTipos(Tipo.COMERCIAL);
        ret = ret +"\nMedia Comercial"+media;
        
        media = somaConsumoTipos(Tipo.INDUSTRIAL);
        media = media/somaTipos(Tipo.INDUSTRIAL);
        ret = ret +"\nMedia Industrial"+media+".";
        
        return ret;
    }

    
    public String relatorio(){
        String rel = "";
        return rel;
    }
}
    

