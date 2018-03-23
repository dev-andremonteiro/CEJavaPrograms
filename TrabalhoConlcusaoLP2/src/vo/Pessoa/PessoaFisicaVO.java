package vo.Pessoa;

import javax.persistence.*;

@Entity
@Table(name = "pessoafisica")
@Inheritance(strategy = InheritanceType.JOINED)
public class PessoaFisicaVO extends PessoaVO{
    @Column(length = 14,nullable = false)
    private String CPF;
    @Column(length = 10,nullable = false)
    private String RG;

    public PessoaFisicaVO() {
    }

    public PessoaFisicaVO(String CPF, String RG) {
        this.CPF = CPF;
        this.RG = RG;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    
    public boolean calcularDigito(String str){
        
        String[] split = ((str.replace(".","")).replace("-","")).split("");
        int x = 10;
        int y = 0;
        int[] result = new int[6];
        while(x > 1){
            result[0] += Integer.parseInt(split[y])*x;
            y++;
            x--;
        }
        result[1] = result[0]%11;
        if(result[1] < 2){
            result[4] = 0;
        }else{
            result[4] = 11 - result[1];
        }
        if(result[4] != Integer.parseInt(split[9])) return false;
        
        x = 11;
        y = 0;
        result[2] = 0;
        while(x > 1){
            result[2] +=  Integer.parseInt(split[y])*x;
            y++;
            x--;
        }
        result[3] = result[2]%11;
        if(result[3] < 2){
            result[5] = 0;
        }else{
            result[5] = 11 - result[3];
        }
        
        return result[5] == Integer.parseInt(split[10]);
    }
    
}
