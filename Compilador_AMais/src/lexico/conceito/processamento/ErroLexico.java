package lexico.conceito.processamento;

public class ErroLexico extends Exception{

    public ErroLexico() {
    }

    public ErroLexico(String message) {
        super("Erro léxico - "+message);
    }
}
