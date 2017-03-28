package conceito.processamento;

public class Cabecote {
    private int cabeca;
    
    public Cabecote(){
        this.cabeca = 0;
    }
    
    public int getCabeca() {
        return cabeca;
    }
    
    public void addCabeca(boolean b){
        if(b){
            this.cabeca++;
        }else{
            this.cabeca--;
        }
    }
}
