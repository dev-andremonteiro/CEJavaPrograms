
package banco;

/**
 *
 * @author André Vinícius Borges de Gois Monteiro
 */
public class ContaCorrente {

    private int banco;
    private int agencia;
    private int conta;
    private float saldo;
    private float taxa;
    private float limite;
    static final float limitemax = 500;
    
    
    public int getBanco(){
        return this.banco;
    }

    public void  setBanco(int banco){
        this.banco = banco;
    }
    
    public int getAgencia(){
        return this.agencia;
    }

    public void  setAgencia(int agencia){
        this.agencia = agencia;
    }
    
    public int getConta(){
        return this.conta;
    }

    public void  setConta(int conta){
        this.conta = conta;
    }
    
    public float getTaxa(){
        return this.taxa;
    }

    public void  setTaxa(float taxa){
        this.taxa = taxa;
    }
    
    public float getLimite(){
        return this.limite;
    }

    public void  setLimite(float limite){
        this.limite = limite;
    }
    
    public void depositar(float valor){
        if(valor > 0){
            this.saldo = valor + this.saldo;
        }else{
            System.out.println("Não é possivel depositar este valor!");
        }
}

    public void sacar(float saque){
        
        if (saque <= 0) {
            System.out.println("Valor de saque invalido!");
        }else{
            if((saque + this.taxa) <= (this.saldo + this.limite)){
                this.saldo = this.saldo - (saque + this.taxa);
            }else{
                System.out.println("Valor de saque indisponivel!");
            }
        }
        
    }
    
    public float getSaldo(){
        return this.saldo;
    }
    
    public float getDisponivel(){
        return (this.saldo + this.limite);
    }
    
}
