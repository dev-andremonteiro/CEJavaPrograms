package sintatico.armazenamento;

public class Log {

    private String texto;

    public Log() {
        texto = "\n\n\n------------------- Log --------------------\n";
    }

    public String getTexto() {
        return (texto + "--------------------------------------------");
    }

    public void setTexto(String texto) {
        this.texto += texto + "\n";
    }

}
