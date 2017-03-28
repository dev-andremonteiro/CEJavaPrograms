package conceito.processamento;

import java.util.Arrays;

public class Fita {
    
    char[] fita;
    private String estado;
    
    public Fita(char[] fita){
        this.fita = fita;
        this.estado = "Q0";
    }
    
    public char lerFita(int cabeca){
        return fita[cabeca];
    }
    
    public void escreverFita(int cabeca, char letra){
        fita[cabeca] = letra;
    }
    
    public void imprimirFita(){
        System.out.println(Arrays.toString(this.fita));
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
