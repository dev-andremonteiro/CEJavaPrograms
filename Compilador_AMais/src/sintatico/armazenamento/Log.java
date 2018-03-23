package sintatico.armazenamento;

public class Log {

    private String texto = "";

    public Log(String texto) {
        this.texto = "\n\n\tLog "+texto+"\t\n\n";
    }

    public String getTexto() {
        return (texto);
    }

    public void setTexto(String texto) {
        this.texto += texto + "\n";
    }

}
