
package conceito;

public class Consumidores {
    private int numConsumidor;
    private float kilWatt;
    private Tipo tipo;
    
    
    
    public int getNumConsumidor() {
        return numConsumidor;
    }

    public void setNumConsumidor(int numConsumidor) {
        this.numConsumidor = numConsumidor;
    }

    public float getKilWatt() {
        return kilWatt;
    }

    public void setKilWatt(float kilWatt) {
        this.kilWatt = kilWatt;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    public float totalAPagar(){
        if(this.tipo == Tipo.RESIDENCIAL){
            return(this.kilWatt*2.67f);
        }
        if (this.tipo == Tipo.COMERCIAL) {
            return(this.kilWatt*3.34f);
        }
        if (this.tipo == Tipo.INDUSTRIAL) {
            return(this.kilWatt*2.97f);
        }
        
        return 0;
    }
    
    
}
