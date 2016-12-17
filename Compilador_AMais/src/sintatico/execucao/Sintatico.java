package sintatico.execucao;

import sintatico.armazenamento.htmltojava;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import lexico.conceito.armazenamento.Token;
import lexico.conceito.processamento.Lexico;
import sintatico.armazenamento.Log;
import sintatico.armazenamento.Node;
import sintatico.armazenamento.Tree;

public class Sintatico {

    private String[][] Tabela;
    private String[][] Exprecoes;
    private Log log;
    private Lexico lex;
    private Tree<String> tree;
    ArrayList<Token> lista_token;
    int x;
    Stack pilha;

    public Sintatico(String caminho) {

        Tabela = new String[36][40];
        Exprecoes = new String[66][2];
        lex = new Lexico(caminho);

        try {
            htmltojava table = new htmltojava("Tabela Sintatica.html", 0);
            Tabela = table.getCampos();
            table = new htmltojava("Tabela Sintatica.html", 1);
            Exprecoes = table.getCampos();
        } catch (IOException ex) {
            System.out.println("Erro ao acessar a tabela sintatica." + ex.toString());
            System.exit(0);
        }

        Token aux_token = new Token();
        aux_token.setToken("$");
        aux_token.setLexema("");
        lista_token = lex.getTokens();
        lista_token.add(aux_token);
        pilha = new Stack();
        pilha.push("$");
        pilha.push("principal");
        Node<String> root = new Node<String>("programa_inicio");
        tree = new Tree<String>(root);
        log = new Log();
        this.x = 0;
        processar(root);
    }

    private void processar(Node<String> pai) {

        int y = 0;
        String temp[] = null;
        Node<String> aux_no2 = null;
        String aux = (String) pilha.pop();
        log.setTexto("(PILHA) Desempilhado :" + aux);
        aux_no2 = new Node<String>(aux);
        pai.addChild(aux_no2);
        log.setTexto("(ARVORE) Inserido no :" + aux_no2.toString());
        pai = aux_no2;
        
        
        if (aux.equals((lista_token.get(x)).getToken())) {
            pai.addChild(new Node<String>("\"" + (lista_token.get(x)).getLexema() + "\""));
            log.setTexto("(ARVORE) Inserido no :" + (lista_token.get(x)).getLexema());
            if (aux.equals("$")) {
                return;
            }
            x++;
        } else if (aux.equals("î")) {
        } else {
            aux = verificarTabela(aux, (lista_token.get(x).getToken()));
            if (aux.equals("-")) {
                System.out.println("Arquivo fonte não reconhecido.");
                System.exit(0);
            } else {
                temp = this.verificarExprecoes(aux);

                y = temp.length - 1;
                while (y >= 0) {
                    pilha.push(temp[y]);
                    log.setTexto("(PILHA) Empilhado :" + temp[y]);
                    y--;
                }
                y = 0;
                while (y < temp.length) {
                    processar(pai);
                    y++;
                }
            }
        }

    }

    private String verificarTabela(String pilha, String token) {
        String saida;
        int aux = 1;
        int aux2 = 1;

        for (int i = 0; i < 36; i++) {
            if (Tabela[i][0].equals(pilha)) {
                aux = i;
            }
        }
        for (int i = 0; i < 40; i++) {
            if (Tabela[0][i].equals(token)) {
                aux2 = i;
            }
        }

        saida = Tabela[aux][aux2];

        return saida;
    }

    private String[] verificarExprecoes(String aux) {

        int z;

        for (z = 0; z < 66; z++) {
            if (aux.equals(Exprecoes[z][0])) {
                break;
            }
        }

        String[] saida = new String[Exprecoes[z].length - 1];

        int w = 1;
        while (w < Exprecoes[z].length) {
            saida[w - 1] = Exprecoes[z][w];
            w++;
        }

        return saida;
    }

    public String getLog() {
        return log.getTexto();
    }

    public void imprimirArvore() {
        //System.out.println("\n");
        //tree.getPreOrderTraversal();
        tree.imprimirArvore((tree.getRoot()), 2, 0);

    }

    public Lexico getLex() {
        return lex;
    }

}
