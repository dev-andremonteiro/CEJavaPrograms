package conceito;

import java.util.ArrayList;
import java.util.List;

public class Notas{  
    private List<NotaAbstrata> listaNota;
    
    public Notas(){
        this.listaNota = new ArrayList<NotaAbstrata>();
    }
    
    public void adicionaNota(NotaAbstrata nota) throws NotaException{
        this.listaNota.add(nota);
    }
    
    public float obterMedia(){
        return this.somatoriaNota()/this.somatoriaPeso();
    }
    
    public float somatoriaNota(){
        float soma = 0;
        for(NotaAbstrata temp : this.listaNota){
            soma+=temp.getValor();
        }
        return soma;
    }
    
    private int somatoriaPeso(){
        int soma=0;
        for(NotaAbstrata temp : this.listaNota){
            soma+=temp.getPeso();
        }
        return soma;
    }
    
}
