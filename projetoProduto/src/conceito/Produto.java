package conceito;


public class Produto {
    private String nome;
    private float preco;
    private float margem;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        if (preco > 0) {
            this.preco = preco;
        }else{
            System.out.println("Preco inválido!");
        }
    }

    public float getMargem() {
        return margem;
    }

    public void setMargem(float margem) {
        if ((margem>=0) && (margem<=100)) {
            this.margem = margem;
        } else {
            System.out.println("Margem inválida!");
        }
    }
    
    public float calcularValorVenda(){
        return (this.preco+((this.preco*this.margem)/100));
    }
    
}
