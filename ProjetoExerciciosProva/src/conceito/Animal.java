package conceito;

public class Animal {
    
    private String nome;
    private String cor;
    private String ambiente;
    private int comprimento;
    private float velocidade;
    private int patas;

    public Animal(String nome, String cor, String ambiente, int comprimento, float velocidade, int patas) {
        this.patas = patas;
        this.ambiente = ambiente;
        this.cor = cor;
        this.nome = nome;
        this.comprimento = comprimento;
        this.velocidade = velocidade;

    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

 
    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public void setComprimento(int comprimento) {
        this.comprimento = comprimento;
    }

    public void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
    }

    public void setPatas(int patas) {
        this.patas = patas;
    }

    @Override
    public String toString() {
        return "\n" + "nome=" + nome + ", cor=" + cor + ", ambiente=" + ambiente + ", comprimento=" + comprimento + ", velocidade=" + velocidade + ", patas=" + patas;
    }
    
    
    
    
}
