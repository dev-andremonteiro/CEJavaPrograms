package executaveis;

import conceito.Construtores;


public class ExecConstrutor {
    public static void main(String[] args) {

        Construtores u1 = new Construtores();
        System.out.println(u1.toString());
        Construtores u2 = new Construtores("Tucurui",8340,5000);
        System.out.println(u2.toString());
        u1.setNome("Itaipu");
        u1.setPotenciaMax(14000);
        System.out.println(u1.toString());
        
    }
    
}
