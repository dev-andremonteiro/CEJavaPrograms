
package conceito;

public class Contador2 {
    
    private static long cont;
    private long valor;
    
    public Contador2(){
        cont++;
        valor++;
    }

    public static long getCont() {
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
