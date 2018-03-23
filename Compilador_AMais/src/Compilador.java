
import geracao.verificar.Gerador;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import lexico.conceito.armazenamento.Simbolo;
import lexico.conceito.armazenamento.Token;
import lexico.conceito.processamento.ErroLexico;
import lexico.conceito.processamento.Lexico;
import semantico.verificar.ErroSemantico;
import semantico.verificar.Semantico;
import sintatico.execucao.ErroSintatico;
import sintatico.execucao.Sintatico;

public class Compilador {

    private String saida;

    public Compilador(String args) {

        ArrayList<Token> tokens = null;
        ArrayList<Simbolo> tabela = null;
        String texto = (System.getProperty("user.dir") + "\\texto2.txt");
        String out = "";

        switch (args) {
            case "-lt"://listagem de tokens
                out += "\n" + ("\tListagem de Tokens\n");
                try {
                    Lexico lex = new Lexico(texto);
                    tokens = lex.getTokens();
                } catch (ErroLexico ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                int x = 0;
                while (x < tokens.size()) {
                    out += "\n" + ((tokens.get(x)).imprimir() + " ");
                    x++;
                }
                out += "\n" + ("");
                this.setSaida(out);
                break;
            case "-ts"://tabela sintatica
                out += "\n" + ("\tTabela de Simbolos\n");
                try {
                    Lexico lex = new Lexico(texto);
                    tabela = lex.getTabela();
                } catch (ErroLexico ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                x = 0;
                while (x < tabela.size()) {
                    out += ((tabela.get(x)).imprimir() + "\n");
                    x++;
                }
                out += "\n" + ("");
                this.setSaida(out);
                break;
            case "-as"://arvore sintatica
                out += "\n" + ("\tArvore Sintatica\n");
                try {
                    Lexico lex = new Lexico(texto);
                    Sintatico sin = new Sintatico(texto);
                    out += sin.imprimirArvore();
                    this.setSaida(out);
                } catch (ErroLexico | ErroSintatico ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

                break;
            case "-ls"://log do analisador sintatico
                try {
                    Lexico lex = new Lexico(texto);
                    Sintatico sin = new Sintatico(texto);
                    out += "\n" + (sin.getLog());
                    this.setSaida(out);
                } catch (ErroLexico | ErroSintatico ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

                break;
            case "-lse":
                try {
                    Lexico lex = new Lexico(texto);
                    Semantico sem = new Semantico(texto);
                    out += "\n" + ("");
                    out += sem.getLog();
                    this.setSaida(out);
                } catch (ErroLexico | ErroSintatico | ErroSemantico ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

                break;
            case "-lgc":
                try {
                    Gerador ger = new Gerador(texto);
                    OutputStream OS = new FileOutputStream("saida.pas");
                    OutputStreamWriter OSW = new OutputStreamWriter(OS);
                    BufferedWriter BW = new BufferedWriter(OSW);
                    String[] Dados = (ger.getSaida()).split("\n");
                    x=0;
                    do {
                        BW.write(Dados[x]);
                        BW.newLine();
                        x++;
                    } while (x < Dados.length);
                    BW.close();
                    
                    this.setSaida(ger.getLog().getTexto()+"\n\nCódigo Gerado com sucesso!");
                } catch (ErroLexico | ErroSintatico | ErroSemantico ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

                break;
            case "-tudo":

                try {
                    Lexico lex = new Lexico(texto);
                    Sintatico sin = new Sintatico(texto);

                    tokens = lex.getTokens();
                    tabela = lex.getTabela();

                    x = 0;
                    out += "\n" + ("\tListagem de Tokens\n");
                    while (x < tokens.size()) {
                        out += "\n" + ((tokens.get(x)).imprimir() + " ");
                        x++;
                    }
                    out += "\n" + ("");
                    out += "\n" + ("\tTabela de Simbolos\n");
                    x = 0;
                    while (x < tabela.size()) {
                        out += "\n" + ((tabela.get(x)).imprimir() + " ");
                        x++;
                    }

                    out += "\n" + ("");
                    out += "\n" + ("\tArvore Sintatica\n\n");
                    out += sin.imprimirArvore();

                    out += "\n" + (sin.getLog());

                    Semantico sem = new Semantico(texto);

                    out += "\n" + sem.getLog();
                    this.setSaida(out);

                } catch (ErroLexico | ErroSintatico | ErroSemantico ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

                break;
        }

    }

    public String getSaida() {
        return saida;
    }

    public void setSaida(String saida) {
        this.saida = saida;
    }

}
