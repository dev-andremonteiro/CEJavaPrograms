package geracao.verificar;

import java.util.ArrayList;
import lexico.conceito.armazenamento.Token;
import lexico.conceito.processamento.ErroLexico;
import lexico.conceito.processamento.Lexico;
import semantico.verificar.ErroSemantico;
import semantico.verificar.Semantico;
import sintatico.armazenamento.Log;
import sintatico.armazenamento.Node;
import sintatico.armazenamento.Tree;
import sintatico.execucao.ErroSintatico;
import sintatico.execucao.Sintatico;

/*
No final o semestre, os alunos devem possuir um compilador totalmente funcional. A implementação é em etapas, e fortemente recomendado que seja realizada em dupla. A dupla deverá não poderá ser alterada.

Etapa 5 - Gerador de Código

O software deverá funcionar nos sistemas operacionais Linux e Windows, e poderá ser implementado em linguagem Java ou C ou C++.

Deve-se manter a mesma composição de alunos (duplas) das fases anteriores.

O compilador deverá ser executado em ambiente texto, porém, a implementação com interface gráfica será considerada elemento adicional. Neste caso, o funcionamento apresentado abaixo deverá ser equivalente no ambiente gráfico.

O Gerador de Código, assim como a fase de análise, é parte do compilador. Deverá ser mantida a mesma gramática das fases anteriores.

O Gerador de Código deve gerar códigos em linguagem C ou Pascal. A geração de código intermediário não é obrigatória, assim como é dispensada implementação da otimização de código.

Esta é a fase final, evidentemente que a geração de código somente ocorrerá se não houver erro no código fonte (as análises léxicas, sintáticas e semânticas não devem produzir erros).



Funcionamento:
$ compilador [opções] arquivo_fonte.fon arquivo_saida.XXXX

Onde [opções]:
-tudo exibe todas as listagens do compilador
-lt exibe a listagem dos Tokens
-ts exibe a tabela de símbolos
-as exibe a árvore sintática
-ls exibe o LOG do analisador sintático
-lse exibe o LOG do analisador semântico
-lgc exibe o LOG da geração de código

a extensão XXXX indica o tipo de arquivo.

As opções são opcionais, portanto, se o usuário não utilizar nenhuma opção, o compilador deverá executar todas as fases da compilação e geração de código.

Evidentemente que os erros deverão ser apresentados em tela. Deverá ter uma identificação das mensagens de erros, informando a fase do compilador (erro léxico, erro sintático, semântico).

Relatório da Fase (Arquivo PDF):
O relatório final será especificado em outro arquivo. 
 */

public class Gerador {

    private Tree tree;
    private ArrayList<Token> declaracoes;
    private String saida;
    private Log log;

    public Gerador(String caminho) throws ErroLexico, ErroSintatico, ErroSemantico {
        Lexico lex = new Lexico(caminho);
        Sintatico sin = new Sintatico(caminho);
        Semantico sem = new Semantico(caminho);
        saida = "";
        log = new Log("Gerador de código");
        tree = sin.getTree();
        declaracoes = new ArrayList<Token>();
        for (Token t : lex.getTokens()) {
            System.out.print(t.getLexema() + "  -  ");
        }
        System.out.println("");
        this.gerarCodigo();
    }

    public void gerarCodigo() {

        ArrayList<Node<Token>> arvore = tree.getPreOrderTraversal();
        saida += "Program principal;\nVAR\n";
        String Aux = "Begin\n";
        boolean dec = false;
        boolean ler = false;
        boolean ig_primeiro = false;
        boolean passou_while = false;
        boolean passou_if = false;
        boolean escrever = false;
        int x = 0;
        for (Node<Token> z : arvore) {
            Token t = z.getData();
            if (t.getToken().equals("declarar_var")) {
                arvore.get(x + 6).getData().setToken(arvore.get(x + 3).getData().getLexema());
                declaracoes.add((arvore.get(x + 6)).getData());
                dec = true;
            }
            if (t.getLinha() > 0) {
                if (t.getLexema().equals("if")) {
                    passou_if=true;
                    Aux += "\nif";
                    log.setTexto("Gerado código: if");
                }
                if (t.getLexema().equals("while")) {
                    passou_while=true;
                    Aux += "\nwhile";
                    log.setTexto("Gerado código: while");
                }
                if (t.getLexema().equals("cin")) {
                    Aux += "\nread(";
                    ler = true;
                    log.setTexto("Gerado código: cin");
                }
                if (t.getLexema().equals("cout")) {
                    Aux += "\nwrite(";
                    escrever= true;
                    ig_primeiro = true;
                    log.setTexto("Gerado código: cout");
                }
                if (t.getLexema().equals("=") && !dec) {
                    Aux += ":=";
                    log.setTexto("Gerado código: recebe");
                }    
                if (t.getLexema().equals(">>")) {
                    if(ig_primeiro){
                        ig_primeiro = false;
                    }else{
                        Aux += ",";
                    }
                    log.setTexto("Gerado código: muito maior");
                }
                if (t.getLexema().equals("==")) {
                    Aux += "=";
                    log.setTexto("Gerado código: igual");
                }
                if (t.getLexema().equals(">")) {
                    Aux += ">";
                    log.setTexto("Gerado código: maior");
                }
                if (t.getLexema().equals("<")) {
                    Aux += "<";
                    log.setTexto("Gerado código: menor");
                }
                if (t.getLexema().equals("!=")) {
                    Aux += "<>";
                    log.setTexto("Gerado código: diferente");
                }
                if (t.getLexema().equals(">=")) {
                    Aux += ">=";
                    log.setTexto("Gerado código: maior igual");
                }
                if (t.getLexema().equals("<=")) {
                    Aux += "<=";
                    log.setTexto("Gerado código: menor igual");
                }
                if (t.getLexema().equals("&&")) {
                    Aux += "and";
                    log.setTexto("Gerado código: E");
                }
                if (t.getLexema().equals("||")) {
                    Aux += "or";
                    log.setTexto("Gerado código: OU");
                }
                if (t.getLexema().equals("+")) {
                    Aux += "+";
                    log.setTexto("Gerado código: mais");
                }
                if (t.getLexema().equals("-")) {
                    Aux += "-";
                    log.setTexto("Gerado código: menos");
                }
                if (t.getLexema().equals("*")) {
                    Aux += "*";
                    log.setTexto("Gerado código: vezes");
                }
                if (t.getLexema().equals("/")) {
                    Aux += "/";
                    log.setTexto("Gerado código: div");
                }
                if (t.getLexema().equals("(")) {
                    Aux += "(";
                    log.setTexto("Gerado código: parentesês");
                }
                if (t.getLexema().equals(")")) {
                    if(passou_while){
                        Aux += ") do";
                        passou_while = false;
                    }else if(passou_if){
                        Aux += ") then";
                        passou_if = false;
                    }else{
                        Aux += ")";
                    }
                    log.setTexto("Gerado código: parênteses");
                }
                if (t.getLexema().equals(";")) {
                    if (dec) {
                        dec = false;
                    } else {
                        if(ler || escrever){
                            Aux += ");\n";
                            ler = false;
                            escrever = false;
                        }else{
                            Aux += ";\n";
                        }
                    }
                    log.setTexto("Gerado código: ponto virgula");
                }
                if (t.getLexema().equals("{")) {
                    Aux += "\nbegin\n";
                    log.setTexto("Gerado código: chave inicio");
                }
                if (t.getLexema().equals("}")) {
                    if(x == arvore.size()-1){
                        Aux+="\nEnd.";
                    }else{
                        Aux += "\nend;\n";  
                    }
                    log.setTexto("Gerado código: chave fim");
                }
                if ((t.getToken().equals("IDENT")||t.getToken().equals("INT")||t.getToken().equals("FLOAT")||t.getToken().equals("STRING")) && !dec) {
                    if(t.getToken().equals("STRING")){
                        Aux += "'"+t.getLexema()+"'";
                    }else{
                        Aux += t.getLexema();
                    }
                    log.setTexto("Gerado código: identificador");
                }
            }

            x++;
        }
        for(Token t: declaracoes){
            if(t.getToken().equals("float")) t.setToken("real");
            if(t.getToken().equals("int")) t.setToken("integer");
            saida+= t.getLexema()+":"+t.getToken().toUpperCase()+";\n";
            log.setTexto("Gerado código: gerando declarações");
        }
        saida +="\n"+Aux;
    }

    public String getSaida() {
        return saida;
    }
    
    public Log getLog(){
        return log;
    }

}
