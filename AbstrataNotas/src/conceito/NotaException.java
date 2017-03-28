
package conceito;

public class NotaException extends Exception {

    public NotaException() {
    }

    public NotaException(String msg) {
        super(msg);
    }

    public String toString() {
        return this.getMessage()+"detalhes: [Exceção ocorrida em Nota]";
    }
}
