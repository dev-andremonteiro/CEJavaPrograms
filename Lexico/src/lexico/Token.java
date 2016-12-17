package lexico;

class Token {
    
        
    private int linha;
    private int coluna;
    private String token;
    private String lexema;

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public String getToken() {
        return token;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }
    
    
}
