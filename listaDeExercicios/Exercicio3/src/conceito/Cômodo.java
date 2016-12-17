
package conceito;

import static java.lang.Math.round;

public class Cômodo {
    
    private float largura;
    private float comprimento;
    private float potência;
    private Tabela tipo;
    
    public Cômodo(){
        this.largura = 0;
        this.comprimento = 0;
    }
    
    public Cômodo(float largura,float comprimento,float potência, Tabela tipo){
        this.comprimento = comprimento;
        this.largura = largura;
        this.potência = potência;
        this.tipo = tipo;
    }

    public float getLargura() {
        return largura;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

    public float getComprimento() {
        return comprimento;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public Tabela getTipo() {
        return tipo;
    }

    public void setTipo(Tabela tipo) {
        this.tipo = tipo;
    }

    public float getPotência() {
        return potência;
    }

    public void setPotência(float potência) {
        this.potência = potência;
    }
    
    public float areaCômodo(){
        return (getLargura()*getComprimento());
    }
    
    public float potenciaNecessaria(){
        if(getTipo() == Tabela.QUARTO){
            return((areaCômodo()/15));
        }
        if(getTipo() == Tabela.SALADETV){
            return((areaCômodo()/15));
        }
        if(getTipo() == Tabela.SALAS){
            return((areaCômodo()/18));
        }
        if(getTipo() == Tabela.COZINHA){
            return((areaCômodo()/18));
        }
        if(getTipo() == Tabela.VARANDA){
            return((areaCômodo()/18));
        }
        if(getTipo() == Tabela.ESCRITORIO){
            return((areaCômodo()/20));
        }
        if(getTipo() == Tabela.BANHEIRO){
            return((areaCômodo()/20));
        }
        return(0);
    }
    
    public Integer numeroDeLampadas(){
         
        return Math.round(potenciaNecessaria()/getPotência());
    }
    
    
}
