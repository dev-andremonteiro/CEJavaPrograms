package lexico.conceito.processamento;

import lexico.conceito.armazenamento.Simbolos;
import lexico.conceito.armazenamento.Simbolo;
import lexico.conceito.entrada.Leitor;
import lexico.conceito.armazenamento.Token;
import java.util.ArrayList;

public class Lexico {

    Token aux_token;
    private ArrayList<Token> tokens;
    private ArrayList<Simbolo> tabela;
    String[] leitura_linha;
    Simbolos sim;
    String lexema;
    char[] ver;
    int coluna;
    int linha;
    int sair;
    boolean foi = false;
    boolean passou = false;
    boolean aspas = false;
    String msgerro = "";
    

    public Lexico(String caminho) throws ErroLexico {

        Leitor lt = new Leitor(caminho);
        String leitura = lt.getEntrada();
        leitura_linha = leitura.split("\n");
        linha = 0;
        sim = new Simbolos();
        tokens = new ArrayList<Token>();
        this.processar();
        this.tratar();
        this.getTabelaSimbolo();
        if(!msgerro.isEmpty()){
            throw new ErroLexico(msgerro);
        }
    }

    void processar() {

        ver = leitura_linha[linha].toCharArray();
        coluna = 0;
        lexema = "";
        aux_token = new Token();
        
        
        
        int aux = 0;
        while (coluna < ver.length) {
            
            if (verificar(Character.toString(ver[coluna]))) {
                lexema = "";
                aux_token = new Token();
                if (ver[aux] == ' ') {
                    aux_token.setColuna(aux + 1);
                } else {
                    aux_token.setColuna(aux);
                }
                aux_token.setLinha(linha);
                if (passou) {
                    coluna++;
                }
                while (aux < coluna) {
                    lexema += ver[aux];
                    aux++;
                }
                if (passou) {
                    coluna--;
                    passou = false;
                }
                if (lexema.trim().length() > 0) {
                    aux_token.setLexema(lexema.trim());
                    aux_token.setToken("IDENT");
                    tokens.add(aux_token);
                }
                if ((coluna == ver.length - 1)) {
                    lexema = "";
                    aux_token = new Token();
                    aux_token.setLinha(linha);
                    aux_token.setColuna(aux);
                    while (aux < coluna + 1) {
                        lexema += ver[aux];
                        aux++;
                    }
                    if (lexema.trim().length() > 0) {
                        aux_token.setLexema(lexema.trim());
                        aux_token.setToken("IDENT");
                        tokens.add(aux_token);
                    }
                }
            }
            coluna++;
        }

        if (aspas) {
            aspas = !aspas;
            lexema = "";
            aux_token = new Token();
            int temp = aux;
            aux_token.setColuna(aux);
            aux_token.setLinha(linha);
            while (aux < coluna) {
                lexema += ver[aux];
                aux++;
            }
            if ((lexema.toCharArray())[0] == ' ') {
                aux_token.setLexema(lexema.replaceFirst(" ", ""));
                aux_token.setColuna(temp + 1);
            } else {
                aux_token.setLexema(lexema);
            }
            aux_token.setToken("IDENT");
            tokens.add(aux_token);
            msgerro += ("\nFalta Aspas  -  Linha: " + aux_token.getLinha());
        }

        linha++;

        if (linha < leitura_linha.length) {
            processar();
        }
    }

    private boolean verificar(String letra) {
        boolean saida = false;
        String[] a = sim.getSimbolos();
        int x = 0;

        if ((!aspas)) {
            while (x < a.length) {
                if (a[x].equals(letra)) {
                    saida = true;
                    foi = saida;
                    if (ver.length < 2) {
                        passou = true;
                    }
                    if (ver[coluna] == '>') {
                        if ((ver[coluna + 1] == '>') || (ver[coluna + 1] == '=')) {
                            saida = false;
                            foi = saida;
                            passou = true;
                        }
                    }
                    if (ver[coluna] == '<') {
                        if ((ver[coluna + 1] == '<') || (ver[coluna + 1] == '=')) {
                            saida = false;
                            foi = saida;
                            passou = true;
                        }
                    }
                    if (ver[coluna] == '!') {
                        if ((ver[coluna + 1] == '=')) {
                            saida = false;
                            foi = saida;
                            passou = true;
                        }
                    }
                    if (ver[coluna] == '=') {
                        if ((ver[coluna + 1] == '=')) {
                            saida = false;
                            foi = saida;
                            passou = true;
                        }
                    }
                    if (ver[coluna] == '&') {
                        if ((ver[coluna + 1] == '&')) {
                            saida = false;
                            foi = saida;
                            passou = true;
                        }
                    }
                    if (ver[coluna] == '|') {
                        if ((ver[coluna + 1] == '|')) {
                            saida = false;
                            foi = saida;
                            passou = true;
                        }
                    }
                }
                if (letra.equals(" ")) {
                    saida = true;
                    foi = saida;
                }

                x++;
            }
        }

        if (letra.equals("\"")) {
            aspas = !aspas;
            foi = false;
        }

        if ((Character.isLetterOrDigit(ver[coluna])) && (foi == true)) {
            saida = true;
            foi = false;
        }

        return saida;
    }

    public void tratar() {
        String[] a = sim.getTerminais();
        String[] b = sim.getSimbolos();
        int x = 0;

        int y;
        int z;

        x = 0;
        while (x < tokens.size()) {
            boolean pass = false;
            boolean pass3 = false;
            aux_token = new Token();
            aux_token = tokens.get(x);
            y = 0;
            while (y < a.length) {
                if (a[y].equals(aux_token.getLexema())) {
                    pass = true;
                    switch (a[y]) {
                        case "principal":
                            aux_token.setToken("PRINCIPAL");
                            break;
                        case "int":
                            aux_token.setToken("INT_VAR");
                            break;
                        case "float":
                            aux_token.setToken("FLOAT_VAR");
                            break;
                        case "string":
                            aux_token.setToken("STRING_VAR");
                            break;
                        case "if":
                            aux_token.setToken("IF");
                            break;
                        case "while":
                            aux_token.setToken("WHILE");
                            break;
                        case "cin":
                            aux_token.setToken("CIN");
                            break;
                        case "cout":
                            aux_token.setToken("COUT");
                            break;
                    }
                }
                y++;
            }
            z = 0;
            while (z < b.length) {
                if (b[z].equals(aux_token.getLexema())) {
                    pass = true;
                    switch (b[z]) {
                        case ";":
                            aux_token.setToken("PONTO_VIRGULA");
                            break;
                        case "<<":
                            aux_token.setToken("MUITO_MENOR");
                            break;
                        case ">>":
                            aux_token.setToken("MUITO_MAIOR");
                            break;
                        case "==":
                            aux_token.setToken("IGUAL");
                            break;
                        case ">":
                            aux_token.setToken("MAIOR");
                            break;
                        case "<":
                            aux_token.setToken("MENOR");
                            break;
                        case "!=":
                            aux_token.setToken("DIFERENTE");
                            break;
                        case "!":
                            aux_token.setToken("CARACTER_INVALIDO");
                            break;
                        case ">=":
                            aux_token.setToken("MAIORIGUAL");
                            break;
                        case "<=":
                            aux_token.setToken("MENORIGUAL");
                            break;
                        case "&&":
                            aux_token.setToken("AND");
                            break;
                        case "&":
                            aux_token.setToken("CARACTER_INVALIDO");
                            break;
                        case "||":
                            aux_token.setToken("OR");
                            break;
                        case "|":
                            aux_token.setToken("CARACTER_INVALIDO");
                            break;
                        case "+":
                            aux_token.setToken("SUM");
                            break;
                        case "-":
                            aux_token.setToken("MINUS");
                            break;
                        case "*":
                            aux_token.setToken("MULT");
                            break;
                        case "/":
                            aux_token.setToken("DIV");
                            break;
                        case "=":
                            aux_token.setToken("RECEBE");
                            break;
                        case "(":
                            aux_token.setToken("ABRE_PAR");
                            break;
                        case ",":
                            aux_token.setToken("VIRGULA");
                            break;
                        case ")":
                            aux_token.setToken("FECHA_PAR");
                            break;
                        case "{":
                            aux_token.setToken("ABRE_CHAVE");
                            break;
                        case "}":
                            aux_token.setToken("FECHA_CHAVE");
                            break;
                    }
                }
                z++;
            }
            
            if (!pass) {
                boolean passed=true;
                char[] palavra = aux_token.getLexema().toCharArray();
                y = 0;
                if (Character.isDigit(palavra[y])) {
                    y = 1;
                    while (y < palavra.length) {
                        if (Character.isLetter(palavra[y])) {
                            y = palavra.length;
                        } else if (Character.isDigit(palavra[y])) {
                        } else {
                            y = palavra.length;
                        }
                        y++;
                    }
                    if (y == palavra.length) {
                        aux_token.setToken("INT");
                        pass = true;
                    } else {
                        aux_token.setToken("CARACTER_INVALIDO");
                    }
                }
                y = 0;
                if (Character.isDigit(palavra[y]) && (!pass)) {
                    y = 1;
                    while (y < palavra.length) {
                        if (Character.isLetter(palavra[y])) {
                            y = palavra.length;
                        } else if (Character.isDigit(palavra[y])) {
                            pass = true;
                        } else if (palavra[y] == '.') {
                            if (pass3) {
                                y = palavra.length;
                            }
                            pass3 = true;
                        } else {
                            y = palavra.length;
                        }
                        y++;
                    }
                    if (y == palavra.length) {
                        aux_token.setToken("FLOAT");
                    } else {
                        aux_token.setToken("CARACTER_INVALIDO");
                    }
                }
                y = 0;
                if (Character.isLetter(palavra[y])) {
                    y = 1;
                    while (y < palavra.length) {
                        if (Character.isLetterOrDigit(palavra[y])) {
                        } else {
                            y = palavra.length;
                        }
                        y++;
                    }
                    if (y == palavra.length) {
                        aux_token.setToken("IDENT");
                    } else {
                        aux_token.setToken("CARACTER_INVALIDO");
                    }
                }
                if (palavra[0] == '\"') {
                    aux_token.setToken("STRING");
                    aux_token.setLexema((aux_token.getLexema().replace("\"", "")));
                }
            }

            if (aux_token.getToken().equals("CARACTER_INVALIDO")) {
                msgerro += ("Caracter Inválido - " + aux_token.getLinha() + " - " + aux_token.getColuna() + " - " + aux_token.getLexema());
                tokens.remove(aux_token);
            }
            x++;
        }

    }

    public void getTabelaSimbolo() {

        Simbolo aux_simbolo = new Simbolo();
        Simbolo aux_simbolo2 = null;
        tabela = new ArrayList();
        aux_token = new Token();
        int x = 0;
        int y = 0;
        int cont = 0;

        while (x < tokens.size()) {
            aux_token = tokens.get(x);
            aux_simbolo = new Simbolo();
            aux_simbolo.setId_simbolo(cont);
            aux_simbolo.setLexema(aux_token.getLexema());
            aux_simbolo.setToken(aux_token.getToken());
            aux_simbolo.addPosicao((aux_token.getLinha()), (aux_token.getColuna()));
            tabela.add(aux_simbolo);

            if (x == 1) {
                x = 1;
            }

            while (y < tabela.size()) {
                aux_simbolo2 = tabela.get(y);

                if ((y < (tabela.size() - 1)) && (tabela.size() > 1)) {
                    if ((aux_token.getToken()) == null ? (aux_simbolo2.getToken()) == null : (aux_token.getToken()).equals(aux_simbolo2.getToken())) {
                        if ((aux_simbolo2.getLexema()) == null ? (aux_token.getLexema()) == null : (aux_simbolo2.getLexema()).equals(aux_token.getLexema())) {
                            tabela.remove(aux_simbolo);
                            aux_simbolo2.addPosicao((aux_token.getLinha()), (aux_token.getColuna()));
                            cont--;
                        }
                    }
                }
                y++;
            }
            cont++;
            y = 0;
            x++;
        }

    }

    public ArrayList<Token> getTokens() {
        return tokens;
    }

    public ArrayList<Simbolo> getTabela() {
        return tabela;
    }

}
