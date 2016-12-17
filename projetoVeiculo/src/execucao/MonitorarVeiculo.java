package execucao;

import veiculo.Veiculo;


public class MonitorarVeiculo {
    public static void main(String[] args) {
        
        Veiculo carro01;
        carro01 = new Veiculo();
        
        
        carro01.setCapacidadeTanque(45);
        carro01.consultarcarro();
        carro01.abastecer(-1);
        carro01.abastecer(43.6f);
        carro01.consultarcarro();
        
        
        carro01.andar(121, 100);
        carro01.consultarcarro();
        carro01.andar(200, 120);
        carro01.consultarcarro();
        carro01.andar(300,10);
        carro01.consultarcarro();
        
        
    }
}
