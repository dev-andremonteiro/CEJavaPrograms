package lexico;

public class Simbolos {

    private char[] simbolos;
    
   
    public Simbolos() {
        simbolos = new char[] {'!','>','<','&','|','=','+','-','*','/','(',')',',','{','}',';'};
    }

    public char[] getSimbolos() {
        return simbolos;
    }
 
}
