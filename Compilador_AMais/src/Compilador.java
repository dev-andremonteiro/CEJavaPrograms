
import java.util.ArrayList;
import lexico.conceito.armazenamento.Simbolo;
import lexico.conceito.armazenamento.Token;
import lexico.conceito.processamento.Lexico;
import sintatico.execucao.Sintatico;

public class Compilador {

    public static void main(String[] args) {
        Sintatico sin = new Sintatico(args[1]);
        Lexico lex = sin.getLex();
        ArrayList<Token> tokens = lex.getTokens();
        ArrayList<Simbolo> tabela = lex.getTabela();

        System.out.println("-------------------------------\n\tCOMPILADOR AMAIS\nDesenvolvido por André Monteiro\n-------------------------------");
        switch (args[0]) {
            case "-lt"://listagem de tokens
                System.out.println("\tListagem de Tokens\n");
                int x = 0;
                while (x < tokens.size()) {
                    System.out.println((tokens.get(x)).imprimir() + " ");
                    x++;
                }
                System.out.println("");
                break;
            case "-ts"://tabela sintatica
                System.out.println("\tTabela de Simbolos\n");
                x = 0;
                while (x < tabela.size()) {
                    System.out.print((tabela.get(x)).imprimir() + " ");
                    x++;
                }
                System.out.println("");
                break;
            case "-as"://arvore sintatica
                System.out.println("\tArvore Sintatica\n");
                sin.imprimirArvore();
                break;
            case "-ls"://log do analisador sintatico
                System.out.println(sin.getLog());
                break;
            case "-tudo":
                x = 0;
                System.out.println("\tListagem de Tokens\n");
                while (x < tokens.size()) {
                    System.out.println((tokens.get(x)).imprimir() + " ");
                    x++;
                }
                System.out.println("");
                System.out.println("\tTabela de Simbolos\n");
                x = 0;
                while (x < tabela.size()) {
                    System.out.println((tabela.get(x)).imprimir() + " ");
                    x++;
                }
                System.out.println("");
                System.out.println("\tArvore Sintatica\n");
                sin.imprimirArvore();

                System.out.println(sin.getLog());

                break;
        }

    }

}
