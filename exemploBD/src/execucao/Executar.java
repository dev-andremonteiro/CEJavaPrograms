package execucao;

import funcoes.Inserir;
import entrada.Menu;


public class Executar {
    
    public static void main(String[] args) {
        
        Menu menu = new Menu();
        int entrada = menu.exibirMenu();
        switch(entrada){
            case 0:
                Inserir ins = new Inserir();
                ins.inserirAluno();
                break;
        }
        
    }
    
}
