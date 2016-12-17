package lexico;

import java.util.List;

public class Lexico {

    Processador pro;
    Token aux_token;
    List<Token> tokens;
    String[] leitura_linha;
    Simbolos sim;
    String lexema;
    char[] ver;
    int coluna;
    int linha;
    int sair;
    boolean foi = false;
    
    
    public Lexico() {
        
        Leitor lt = new Leitor();
        String leitura = lt.getEntrada();
        leitura_linha = leitura.split("\n");
        linha = 0;
    }

    void processar() {
            
            ver = leitura_linha[linha].toCharArray();
            coluna = 0;
            lexema="";
 
            while(coluna < ver.length){
                if(verificar(ver[coluna])){
                        if(lexema.trim() != "")System.out.println(lexema.trim());
                        lexema="";
                }
                
                coluna++;
            }
            
            linha++;
            
            if(linha<leitura_linha.length)processar();
    }

    private boolean verificar(char letra) {
        boolean saida = false;
        
        sim = new Simbolos();
        char[] a = sim.getSimbolos();
        int x=0;
        
        while(x < a.length){
            if(a[x] == letra){
                saida = true;
                foi = saida;
                
                if(ver[coluna] == '>'){
                    if((ver[coluna+1] == '>')||(ver[coluna+1] == '=')){
                        saida = false;
                        foi = saida;
                    }
                }
                if(ver[coluna] == '<'){
                    if((ver[coluna+1] == '<')||(ver[coluna+1] == '=')){
                        saida = false;
                        foi = saida;
                    }
                }
                if(ver[coluna] == '!'){
                    if((ver[coluna+1] == '=')){
                        saida = false;
                        foi = saida;
                    }
                }
                if(ver[coluna] == '='){
                    if((ver[coluna+1] == '=')){
                        saida = false;
                        foi = saida;
                    }
                }
                if(ver[coluna] == '&'){
                    if((ver[coluna+1] == '&')){
                        saida = false;
                        foi = saida;
                    }
                }
                if(ver[coluna] == '|'){
                    if((ver[coluna+1] == '|')){
                        saida = false;
                        foi = saida;
                    }
                }
            lexema += ver[coluna];
            }
            if(letra == ' '){
                saida = true;
                foi = saida;
            }
        
        x++;
        }
        
        if((Character.isLetterOrDigit(ver[coluna]))&&(foi == true)) {
            saida = true;
            foi = false;
            lexema += ver[coluna];
        }
        
        if(saida==false)lexema += ver[coluna];
        
        
        return saida;
    }

    
    
    
    
    
}
