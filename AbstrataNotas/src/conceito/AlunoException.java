
package conceito;

public class AlunoException extends Exception {

    public AlunoException() {
    }

    public AlunoException(String msg) {
        super(msg);
    }

    public String toString() {
        return this.getMessage()+"detalhes: [Exceção ocorrida em Aluno]";
    }
    
}
