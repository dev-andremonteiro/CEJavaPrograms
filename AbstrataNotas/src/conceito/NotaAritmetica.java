
package conceito;

public class NotaAritmetica extends NotaAbstrata{
    private float valor;
    
    public NotaAritmetica(){
        this.valor=0;
    }
    
    public NotaAritmetica(float valor){
        this.valor=valor;
    }
    
    public int getPeso(){
        return 1;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) throws NotaException {
        if(valor>=0&&valor<=10)this.valor = valor;
        throw new NotaException("O valor da nota deve ficar entre 0 e 10");
    }
    
}
