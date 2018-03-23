
package semantico.verificar;

public class ErroSemantico extends Exception{

    public ErroSemantico() {
    }

    public ErroSemantico(String message) {
        super("Erro semântico - "+message);
    }
}