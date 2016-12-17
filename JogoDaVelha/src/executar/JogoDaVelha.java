package executar;

import conceito.Jogador;
import conceito.Login;
import conceito.Matriz;
import conceito.Turno;
import java.util.Scanner;


public class JogoDaVelha {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = 0;
        
        System.out.println("Qual modo você deseja jogar? 1 - J1 vs J2 0 - J1 vs Comp");
        Login login = new Login(scan.nextInt());//scan.nextInt()
        
        if(login.getOpcao() != 0){
            System.out.println("ALOKA");
        }else{
            System.out.println("OLOCO");
        }
        
        System.out.println("Escolha a opção de simbolo para o Jogador 1:  (1 = X ou 0 = O)");
        Jogador jog1 = new Jogador(true); //scan.nextBoolean() PROBLEMA
        Jogador jog2 = new Jogador(!jog1.isX());
        
        Turno turno = new Turno();
        Matriz mat = new Matriz(3);// Usuário escolhe.
        turno.first();
        
        int lin;
        int col;
        
        do{
            do{
                System.out.println("Digite a Linha:");
                lin = scan.nextInt();
                System.out.println("Digite a Coluna:");
                col = scan.nextInt();
            }while(mat.verificar(lin,col));
            mat.inserirMatriz(turno.getJogador(), col, lin);
            mat.imprimirMatriz();
            x = mat.winner();
            if(x == 0){
                turno.getTurno();
            }
        }while(x == 0);
        
        if(x == 3) System.out.println("O Jogador1 Ganhou!");
        if(x == -3) System.out.println("O Jogador2 Ganhou!");
        
    }
    
}
