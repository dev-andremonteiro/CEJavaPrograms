
package negocio;

import classes.Sexo;

public class Crianca {
    private Sexo sexo;
    private float peso;
    private int ano;
    
    
    public Crianca(){
        sexo =  Sexo.MASCULINO;
        peso = (2.5f);
        ano = 2015;
    }
    
    public Crianca(Sexo SEXO,float PESO, int ANO){
        sexo = SEXO;
        peso = PESO;
        ano = ANO;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if(ano >=1000 ) this.ano = ano;
    }
    
    
}
