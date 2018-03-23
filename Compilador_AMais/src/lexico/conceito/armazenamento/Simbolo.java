package lexico.conceito.armazenamento;

import java.util.ArrayList;

public class Simbolo {

    private int id_simbolo;
    private String token;
    private String lexema;
    private ArrayList<int[]> posicao;
    private int[] aux;

    public Simbolo() {
        this.id_simbolo = 0;
        this.lexema = " ";
        this.token = " ";
        posicao = new ArrayList();
        aux = new int[2];
    }

    public void setId_simbolo(int id_simbolo) {
        this.id_simbolo = id_simbolo;
    }

    public int getId_simbolo() {
        return id_simbolo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public ArrayList<int[]> getPosicao() {
        return posicao;
    }

    public void addPosicao(int linha, int coluna) {
        aux = new int[2];
        aux[0] = linha;
        aux[1] = coluna;
        posicao.add(aux);
    }

    public String imprimir() {
        return (this.getId_simbolo() + " - {" + this.getToken() + "} - " + this.getLexema() + " - " + this.getIPosicao(this.getPosicao()));
    }

    private String getIPosicao(ArrayList<int[]> ex) {
        int aux = 0;
        String saida = "";
        int[] x;

        while (aux < ex.size()) {
            x = ex.get(aux);
            saida += " (" + x[0] + "," + x[1] + ");";
            aux++;
        }
        return saida;
    }

}
