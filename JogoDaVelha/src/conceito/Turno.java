package conceito;

import java.util.Random;

public class Turno {
    
    Random x = new Random();
    int y;
    
    public boolean getJogador(){
        return (y == 0);
    }
    
    public void first(){
        y = x.nextInt(2);
        if(y == 1){
            System.out.println("Turno: Jogador2");
        }else{
            System.out.println("Turno: Jogador1");
        }
    }
    
    public void getTurno(){
        inverter();
        if(y == 1){
            System.out.println("Turno: Jogador2");
        }else{
            System.out.println("Turno: Jogador1");
        }
    }
    
    public void inverter(){
        if(y==1){
            y=0;
        }else y=1;
    }
    
    
    
}
