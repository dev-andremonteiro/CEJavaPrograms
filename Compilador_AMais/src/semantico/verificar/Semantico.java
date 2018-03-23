package semantico.verificar;

import java.util.ArrayList;
import lexico.conceito.armazenamento.Token;
import lexico.conceito.processamento.ErroLexico;
import lexico.conceito.processamento.Lexico;
import sintatico.armazenamento.Log;
import sintatico.armazenamento.Node;
import sintatico.armazenamento.Tree;
import sintatico.execucao.ErroSintatico;
import sintatico.execucao.Sintatico;

/**
 *
 * @author André
 *
 * O Analisador Semântico deve realizar a análise semântica, além de produzir o
 * log de operações semânticas (por exemplo, informar a visita ao nó da árvore a
 * ação semântica realizada).
 *
 * Esta fase do compilador deverá executar, no mínimo: - verificação da
 * declaração prévia de variável; ( Declarar antes de utilizar ) - verificação
 * da declaração duplicada de variável; ( Declarar 2 vezes a mesma variável ) -
 * verificação de tipos em operações com variáveis (entrada, saída,
 * processamento).
 *
 * Funcionamento: $ compilador [opções] arquivo_fonte.fon
 *
 * Onde [opções]: -tudo exibe todas as listagens do compilador -lt exibe a
 * listagem dos Tokens -ts exibe a tabela de símbolos -as exibe a árvore
 * sintática -ls exibe o LOG do analisador sintático -lse exibe o LOG do
 * analisador semântico
 *
 * As opções são opcionais, portanto, se o usuário não utilizar nenhuma opção, o
 * compilador deverá executar todas as fases da compilação, estudadas até o
 * momento.
 *
 * Evidentemente que os erros deverão ser apresentados em tela. Deverá ter uma
 * identificação das mensagens de erros, informando a fase do compilador (erro
 * léxico, erro sintático, semântico).
 *
 *
 * Relatório da Fase (Arquivo PDF): O relatório da fase deverá conter, no
 * mínimo: - identificação da dupla - listagem do código fonte do compilador -
 * gramática (se houver alteração da fase anterior) - resultado de quatro testes
 * (dois arquivos fontes corretos, e dois com erros sintáticos)
 *
 * Os dois programas que funcionam devem utilizar TODAS as estruturas
 * gramaticais.
 */
public class Semantico {
    
    private Lexico lex;
    private Sintatico sin;
    private Tree tree;
    private ArrayList<Token> declaracoes;
    private ArrayList<ArrayList<Token>> expressoes;
    private Log log;

    public Semantico(String caminho) throws ErroLexico, ErroSintatico, ErroSemantico {
        lex = new Lexico(caminho);
        log = new Log("Semântico");
        sin = new Sintatico(caminho);
        this.tree = sin.getTree();
        this.declaracoes = new ArrayList<Token>(){
            @Override
            public boolean contains(Object o) {
                
                for(Token t:this){
                    if(((t.getLexema()).split("[.]"))[0].equals(((Token) o).getLexema())){
                        return true;
                    }
                }
                return false;
            }
        };
        this.expressoes = new ArrayList<ArrayList<Token>>();
        this.verificarDeclaracoes();
        this.verificarExpressoes();
    }

    public void verificarDeclaracoes() throws ErroSemantico {
        boolean passou = false;
        boolean expnum = false;
        boolean explog = false;
        String tipo = "";
        
        Tree treeAUX = getTree();
        ArrayList<Node<Token>> tokens = tree.getPreOrderTraversal();
        int x = 0;
        for (Node<Token> t : tokens) {

            if (t.getData().getToken().equals("declarar_var")) {
                
                if (!(this.declaracoes.contains((tokens.get(x + 6)).getData()))) {
                    tipo = ((tokens.get(x + 3)).getData()).getLexema();
                    String aux = (tokens.get(x + 6)).getData().getLexema();
                    this.log.setTexto("Variável: " + (tokens.get(x + 6)).getData().getLexema() + " verificada.");
                    this.declaracoes.add((tokens.get(x + 6)).getData());
                    (tokens.get(x + 6)).getData().setToken(tipo);
                } else {
                    throw new ErroSemantico("Variável \"" + ((tokens.get(x + 6)).getData().getLexema()) + "\" já foi declarada.");
                } 
                
            }
            
            
            if ((t.getData().getToken().equals("IDENT")) && (t.getData().getLexema().equals("IDENT"))) {
                
                    for (Token comp : this.declaracoes) {
                        if (tokens.get(x+1).getData().getLexema().equals(((comp.getLexema())))) {
                            tokens.get(x+1).getData().setToken(comp.getToken());
                            passou = true;
                        }
                    }
                    if (!passou) {
                        throw new ErroSemantico("Variável \"" + (tokens.get(x+1)).getData().getLexema() + "\" não foi declarada.");
                    }
                    
            }
            
            
            if ((t.getData().getToken().equals("exp_num"))) {

                expressoes.add(new ArrayList<Token>());
                if(!(tokens.get(x - 4).getData().getLexema().equals("declarar_var2")))expressoes.get(expressoes.size() - 1).add(tokens.get(x - 4).getData());
                else expressoes.get(expressoes.size() - 1).add(tokens.get(x - 5).getData());
                expnum = true;
            }
            if ((t.getData().getToken().equals("exp_log"))) {
                expressoes.add(new ArrayList<Token>());
                explog = true;
            }
            
            
            if (expnum) {
                if (t.getData().getToken().equals("PONTO_VIRGULA")) {
                    expnum = false;
                } else if (!(t.getData().getToken().equals(t.getData().getLexema()))) {

                    ArrayList<Token> comum = expressoes.get(expressoes.size() - 1);
                    comum.add(t.getData());
                    
                }
            }else if (explog) {
                if (t.getData().getToken().equals("PONTO_VIRGULA") || t.getData().getToken().equals("FECHA_PAR") || t.getData().getToken().equals("OR") || t.getData().getToken().equals("AND")) {
                    explog = false;
                } else if (!(t.getData().getToken().equals(t.getData().getLexema()))) {

                    ArrayList<Token> comum = expressoes.get(expressoes.size() - 1);
                    comum.add(t.getData());

                }
            }else{
                
                if(t.getData().getToken().equals("atribuicao1") && !(tokens.get(x+1).getData().getToken().equals("exp_num"))){
                    ArrayList<Token> comum = new ArrayList<Token>();
                    expressoes.add(comum);
                    comum.add(tokens.get(x - 4).getData());
                    comum.add(tokens.get(x + 2).getData());
                }
                
            }
            passou = false;
            x++;
        }

    }
    
    public void verificarExpressoes() throws ErroSemantico{
        
        int x = 0;
        for (ArrayList<Token> a : expressoes) {
            String tipo_exp = "";
            tipo_exp = a.get(0).getToken().toLowerCase();
            String expressao = "";
            
            int y = 0;
            for(Token b:a){
                expressao += (b.getLexema());
                if(y == 0){
                    if(a.size() % 2 == 0){
                        expressao += "=";
                    }
                } 
                y++;
            }

            for (Token b : a) {
                String tipo = b.getToken().toLowerCase();
                if (tipo_exp.equals("int")) {

                    if (tipo.equals("string")) {
                        throw new ErroSemantico("Variável  \"" + b.getLexema() + "\" do tipo string não pode fazer parte da expressão \""+expressao+"\".\n Tipo esperado "+tipo_exp+".");
                    }
                    if (tipo.equals("float")) {
                        throw new ErroSemantico("Variável  \"" + b.getLexema() + "\" do tipo float não pode fazer parte da expressão \""+expressao+"\"\n Tipo esperado "+tipo_exp+".");
                    }

                }
                if (tipo_exp.equals("float")) {

                    if (tipo.equals("string")) {
                        throw new ErroSemantico("Variável  \"" + b.getLexema() + "\" do tipo string não pode fazer parte da expressão \""+expressao+"\"\n Tipo esperado \"float\" ou \"int\".");
                    }

                }
                if (tipo_exp.equals("string")) {

                    if (tipo.equals("int")) {
                        throw new ErroSemantico("Variável  \"" + b.getLexema() + "\" do tipo int não pode fazer parte da expressão \""+expressao+"\"\n Tipo esperado "+tipo_exp+".");
                    }
                    if (tipo.equals("float")) {
                        throw new ErroSemantico("Variável  \"" + b.getLexema() + "\" do tipo float não pode fazer parte da expressão \""+expressao+"\"\n Tipo esperado "+tipo_exp+".");
                    }
                }
            }
            this.log.setTexto("Verificada expressao " + expressao + ".");
            x++;
        }
        
    }
    
    public String getLog() {
        return log.getTexto();
    }

    public void setLog(Log log) {
        this.log = log;
    }

    public Sintatico getSin() {
        return sin;
    }

    public void setSin(Sintatico sin) {
        this.sin = sin;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }



    public ArrayList<Token> getDeclaracoes() {
        return declaracoes;
    }

    public void setDeclaracoes(ArrayList<Token> declaracoes) {
        this.declaracoes = declaracoes;
    }

    public ArrayList<ArrayList<Token>> getExpressoes() {
        return expressoes;
    }

    public void setExpressoes(ArrayList<ArrayList<Token>> expressoes) {
        this.expressoes = expressoes;
    }

}
