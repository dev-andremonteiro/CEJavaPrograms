// André Vinícius Borges de Gois Monteiro
// Engenharia da Computação IFMT 5º Semestre

package banco;

import java.util.Scanner;


public class MainContaCorrente {    
    public static void main(String[] args){
   
        ContaCorrente conta01 = new ContaCorrente();
        Scanner input = new Scanner(System.in);
        
        
        System.out.println("Digite a Agência:");
        conta01.setAgencia(input.nextInt());
        System.out.println("Digite o numero do Banco:");
        conta01.setBanco(input.nextInt());
        System.out.println("Digite o numero da Conta:");
        conta01.setConta(input.nextInt());
        System.out.println("Digite o limite:");
        conta01.setLimite(input.nextFloat());
        System.out.println("Digite a taxa de saques:");
        conta01.setTaxa(input.nextFloat());
        
        
        System.out.println("Agencia :"+conta01.getAgencia());
        System.out.println("Banco :"+conta01.getBanco());
        System.out.println("Conta :"+conta01.getConta());
        System.out.println("Saldo :"+conta01.getSaldo());
        System.out.println("Disponivel :"+conta01.getDisponivel());
        System.out.println("--------------------------");
        
        conta01.depositar(5000);
        System.out.println("Saldo :"+conta01.getSaldo());
        System.out.println("Disponivel :"+conta01.getDisponivel());
        System.out.println("--------------------------");
        
        conta01.sacar(2500);
        System.out.println("Saldo :"+conta01.getSaldo());
        System.out.println("Disponivel :"+conta01.getDisponivel());
        System.out.println("--------------------------");
        
        conta01.sacar(2496);
        System.out.println("Saldo :"+conta01.getSaldo());
        System.out.println("Disponivel :"+conta01.getDisponivel());
        System.out.println("--------------------------");
        
        conta01.depositar(492);
        System.out.println("Saldo :"+conta01.getSaldo());
        System.out.println("Disponivel :"+conta01.getDisponivel());
        System.out.println("--------------------------");
        
        conta01.sacar(1000);   
        
    }
    
}
