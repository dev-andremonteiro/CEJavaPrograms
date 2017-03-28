
package conceito;

public class NotaPonderada extends NotaAritmetica{
    private int peso;

    public NotaPonderada(){
        this.peso=0;
    }
    
    public NotaPonderada(int peso){
        this.peso=peso;
    }
    
    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    public float getvalor(){
        return super.getValor();
    }
}
