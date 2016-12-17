// André Vinícius Borges de Gois Monteiro
// Engenharia da Computação IFMT 5º Semestre

package veiculo;


public class Veiculo {
    private int quilometragem;
    private float combustivel;
    private float capacidadeTanque;

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {

        if (quilometragem > 0) {
            this.quilometragem = quilometragem;
        } else {
            System.out.println("Valor inválido de quilometragem!");
        }

    }

    public float getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(float combustivel) {
        
        if (combustivel > 0) {
            this.combustivel = combustivel;
        }else{
            System.out.println("Valor inválido de combustivel!");
        }
    }

    public float getCapacidadeTanque() {
        return capacidadeTanque;
    }

    public void setCapacidadeTanque(float capacidadeTanque) {
        
        if (capacidadeTanque > 0) {
            this.capacidadeTanque = capacidadeTanque;
        }else{
            System.out.println("Valor inválido de capacidade!");
        }
        
    }
    
    public void abastecer(float quantidade){
        
        if((quantidade > 0)&&((quantidade + this.combustivel) <= this.capacidadeTanque)){
            this.combustivel = this.combustivel + quantidade;
        }else{
            System.out.println("Valor inválido para abastecer!");
        }
    }
    
    public void andar(int quilometros, int velocidade){
        
        if(this.combustivel < 0.13){
            System.out.println("O veiculo está sem combustivel!");
            return;
        }
        
        
        if ((quilometros > 1)&&(velocidade > 1)) {
        
            float consumo = 0;
            
        if(velocidade <= 10){
            consumo = 1;
        }else if(velocidade <= 20){
            consumo = 0.5f;
        }else if(velocidade <= 30){
            consumo = 0.33f;
        }else if(velocidade <= 50){
            consumo = 0.20f;
        }else if(velocidade <= 70){
            consumo = 0.14f;
        }else if(velocidade <= 100){
            consumo = 0.12f;
        }else if(velocidade <= 120){
            consumo = 0.08f;
        }else if(velocidade <= 140){
            consumo = 0.1f;
        }else if(velocidade <= 160){
            consumo = 0.13f;
        }else{
            System.out.println("Velocidade Inválida!");
            return;
        }
        
        if((consumo * quilometros) <= this.combustivel){
            
            this.quilometragem = this.quilometragem + (quilometros);
            this.combustivel = this.combustivel - (consumo * quilometros);
            System.out.println("O Veiculo andou "+quilometros+" quilometros.");
            
        }else{
            this.combustivel = quilometros - (((consumo * quilometros) - this.combustivel) / consumo);
            this.quilometragem =(int) ((int) this.quilometragem + (this.combustivel));
            System.out.println("O veiculo PAROU! Ele conseguiu andar "+(int) this.combustivel+" quilometros");
            esvaziarTanque();
            
        }
            
        } else {
            System.out.println("Valores de entrada inválidos!");
        }
               
    }
    
    public void zerarKilometragem(){
        this.quilometragem = 0;
    }
    
    public void esvaziarTanque(){
        this.combustivel = 0;
    }

    public void consultarcarro(){
        System.out.println("--------------------------------------");
        System.out.println("Combustivel :"+getCombustivel());
        System.out.println("Quilometragem :"+getQuilometragem());
        System.out.println("Combustivel MAX :"+getCapacidadeTanque());
        System.out.println("--------------------------------------");
    }
}

