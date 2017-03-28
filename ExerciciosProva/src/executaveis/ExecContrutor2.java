
package executaveis;

import conceito.Construtores2;

public class ExecContrutor2 {
    public static void main(String[] args) {
        
        Construtores2 u1 = new Construtores2();
        System.out.println(u1.toString());
        Construtores2 u2 = new Construtores2("Tucurui",8340,5000);
        System.out.println(u2.toString());
        u1.copiarContrutores2(u2);
        System.out.println(u1.toString());
        u1.setPotenciaMax(14000);
        u1.setNome("Itaipu");
        System.out.println(u1.toString());
        
    }
}
