
package conceito;

public class Peixe extends Animal{
    
    private String caracteristica;
    
    public Peixe(String nome,String caracteristica,int comprimento,float velocidade){
        super(nome, "Cinzento", "Mar", comprimento, velocidade, 0);
        this.caracteristica = caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    @Override
    public String toString() {
        return "-------Peixe------\n" + "caracteristica=" + caracteristica + super.toString();
    }
    
}
