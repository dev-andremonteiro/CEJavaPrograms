package conceito;

public class Construtores {

    private String nome;
    private double potenciaMax;
    private double geracaoAtual;
    
    public Construtores(){
        nome = "sem nome";
        potenciaMax = 0;
        geracaoAtual = 0;
    }
    
    public Construtores(String s,double p,double g){
        nome = s;
        potenciaMax = p;
        geracaoAtual = g;
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
        this.geracaoAtual = geracaoAtual;
    }

    @Override
    public String toString() {
        return "Construtores{" + "nome=" + nome + ", potenciaMax=" + potenciaMax + ", geracaoAtual=" + geracaoAtual + '}';
    }
    
}
