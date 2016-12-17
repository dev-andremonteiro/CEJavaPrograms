
package conceito;

public class Contador {
    
    private static long cont;
    private long valor;
    
    public Contador(){
        cont++;
        valor++;
    }

    public long getCont() {
        return cont;
    }

    public void zerarCont(){
        cont = 0;
    }
    
    public long getValor() {
        return valor;
    }
    
    public void zerarValor(){
        valor = 0;
    }
    
}
