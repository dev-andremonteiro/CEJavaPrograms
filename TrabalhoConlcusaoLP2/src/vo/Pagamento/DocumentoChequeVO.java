package vo.Pagamento;

import javax.persistence.*;


@Entity
@Table(name = "documentocheque")
public class DocumentoChequeVO extends DocumentoPagamentoVO{
    @Column(length = 10,nullable = false)
    private String agencia;
    @Column(length = 10,nullable = false)
    private String conta;
    @ManyToOne(fetch = FetchType.EAGER)
    private BancoVO bancoVO;

    public DocumentoChequeVO(){
    }

    public DocumentoChequeVO(String agencia, String conta, BancoVO bancoVO) {
        this.agencia = agencia;
        this.conta = conta;
        this.bancoVO = bancoVO;
    }

    public BancoVO getBancoVO() {
        return bancoVO;
    }

    public void setBancoVO(BancoVO bancoVO) {
        this.bancoVO = bancoVO;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }
    
}
