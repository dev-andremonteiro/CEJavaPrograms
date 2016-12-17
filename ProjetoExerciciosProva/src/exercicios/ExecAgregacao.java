package exercicios;

import conceito.Peixe;

public class ExecAgregacao {
    public static void main(String[] args) {
        Peixe pe = new Peixe("Pacú", "Barbatanas e Cauda", 20, 30);
        
        System.out.println("----------------------------------\n"+pe.toString()+"\n=============================");
        
    }
}
