package lexico.conceito.armazenamento;

public class Simbolos {

    private String[] simbolos;
    private String[] terminais;

    public Simbolos() {
        simbolos = new String[]{"!", ">", "<", "&", "|", "=", "+", "-", "*", "/", "(", ")", ",", "{", "}", ";", ">>", "<<", "!=", "==", "&&", "||"};
        terminais = new String[]{"principal", "string", "int", "float", "if", "while", "cin", "cout"};
    }

    public String[] getSimbolos() {
        return simbolos;
    }

    public String[] getTerminais() {
        return terminais;
    }

}
