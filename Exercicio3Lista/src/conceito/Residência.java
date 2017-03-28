package conceito;

import java.util.ArrayList;

public class Residência {
    
    ArrayList<Cômodo> comodo;
    
    public Residência(){
        this.comodo = new ArrayList<Cômodo>();
    }
    
    public void criarCômodo(Cômodo com1){
        comodo.add(com1);
    }
        
    public float totalLampadas(){
        float temporario = 0;
    
        for(Cômodo temp:this.comodo){
            temporario = temp.numeroDeLampadas() + temporario;
        }
        
        return (temporario);
    }
    
    public float totalPotencia(){
        float temporario = 0;
    
        for(Cômodo temp:this.comodo){
            temporario = temp.potenciaNecessaria() + temporario;
        }
        
        return (temporario);
    }
    
    public String relatorio(Cômodo com1){
            String rel= "\n--------------------\n"+
            "\tTipo:"+com1.getTipo()+"\n"+
            "\tÁrea:"+com1.areaCômodo()+"\n"+
            "\tPotência de Iluminação:"+com1.potenciaNecessaria()+"\n"+
            "\tNumero de Lampadas:"+com1.numeroDeLampadas()+"\n"+
            "--------------------\n";
            return (rel);
    }
    
    public String relatorio(){
        String rel = "";
        
        for(Cômodo temp:this.comodo){
                 rel = "\n------------CÔMODO------------\n"+
                "\tTipo:"+temp.getTipo()+".\n"+
                "\tÁrea:"+temp.areaCômodo()+".\n"+
                "\tPotência de Iluminação:"+temp.potenciaNecessaria()+".\n"+
                "\tNumero de Lampadas:"+temp.numeroDeLampadas()+".\n"+
                "------------------------------\n" + rel;
        }
        
        rel = "\n---------RESIDÊNCIA---------\n"+
            "\tTotal Potência:"+totalPotencia()+".\n"+
            "\tTotal Lampadas:"+totalLampadas()+".\n"+
            "----------------------------\n" + rel;
            return (rel);
    }    
    
}
