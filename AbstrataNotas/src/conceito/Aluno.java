
package conceito;

public class Aluno {
    private int matricula;
    private String nome;
    private Notas notas;

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) throws AlunoException{
        if(matricula>0)this.matricula = matricula;
        else throw new AlunoException("Matricula inválida - deve ser maior que zero");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws AlunoException{
        if(nome.length() > 0)this.nome = nome;
        else throw new AlunoException("Nome inválido - não pode ser vazio");
    }

    public Notas getNotas() {
        return notas;
    }

    public void setNotas(Notas notas) throws AlunoException {
        if(notas != null)this.notas = notas;
        else throw new AlunoException("A coleção de notas está vazia.");
    }
    
    public Aluno(){
        this.matricula=0;
        this.nome = "";
        this.notas = null;
    }
    
    public Aluno(int matricula,String nome){
        this.matricula = matricula;
        this.nome = nome;
        this.notas = null;
    }
    
    public float getMedia(){
        return this.getNotas().obterMedia();
    }
    
    public float getSomatoriaNotas(){
        return this.getNotas().somatoriaNota();
    }
    
}
