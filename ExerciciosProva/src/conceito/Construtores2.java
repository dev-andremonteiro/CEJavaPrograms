package conceito;

public class Construtores2 {

    private String nome;
    private double potenciaMax;
    private double geracaoAtual;
    
    public Construtores2(){
        nome = "sem nome";
        potenciaMax = 0;
        setGeracaoAtual(0);
    }
    
    public Construtores2(String s,double p,double g){
        nome = s;
        potenciaMax = p;
        setGeracaoAtual(g);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPotenciaMax() {
        return potenciaMax;
    }

    public void setPotenciaMax(double potenciaMax) {
        this.potenciaMax = potenciaMax;
    }

    public double getGeracaoAtual() {
        return geracaoAtual;
    }

    public void setGeracaoAtual(double geracaoAtual) {
        if(geracaoAtual > 0)this.geracaoAtual = geracaoAtual;
        else System.out.println("Geracao não pode ser negativa!");
    }

    @Override
    public String toString() {
        return "Construtores2{" + "nome=" + getNome() + ", potenciaMax=" + getPotenciaMax() + ", geracaoAtual=" + getGeracaoAtual() + '}';
    }
    
    public void copiarContrutores2(Construtores2 u){
        setNome(u.getNome());
        setPotenciaMax(u.getPotenciaMax());
        setGeracaoAtual(u.getGeracaoAtual());
        
    }
    
}
