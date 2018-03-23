package sintatico.execucao;

public class ErroSintatico extends Exception{

    public ErroSintatico() {
    }

    public ErroSintatico(String message) {
        super("Erro sintático -"+message);
    }
}
