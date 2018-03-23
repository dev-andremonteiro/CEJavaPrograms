package vo;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "baixa")
public class BaixaVO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_baixa;
    
    @Column (length = 300 ,nullable = false)
    private String observacao;
    
    @Column (nullable = false)
    private Date dt_baixa;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private EmprestimoVO emprestimo;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private TipoBaixaVO tipoBaixa;

    public BaixaVO() {
        this.emprestimo = null;
        this.tipoBaixa = null;
        this.id_baixa = 0;
        this.observacao = "";
    }

    /**
     * @return the idBaixa
     */
    public int getIdBaixa() {
        return id_baixa;
    }

    /**
     * @param idBaixa the idBaixa to set
     */
    public void setIdBaixa(int idBaixa) {
        this.id_baixa = idBaixa;
    }

    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    /**
     * @return the dt_baixa
     */
    public Date getDataBaixa() {
        return dt_baixa;
    }

    /**
     * @param dataBaixa the dt_baixa to set
     */
    public void setDataBaixa(Date dataBaixa) {
        this.dt_baixa = dataBaixa;
    }

    /**
     * @return the emprestimo
     */
    public EmprestimoVO getEmprestimo() {
        return emprestimo;
    }

    /**
     * @param emprestimo the emprestimo to set
     */
    public void setEmprestimo(EmprestimoVO emprestimo) {
        this.emprestimo = emprestimo;
    }

    /**
     * @return the tipoBaixa
     */
    public TipoBaixaVO getTipoBaixa() {
        return tipoBaixa;
    }

    /**
     * @param tipoBaixa the tipoBaixa to set
     */
    public void setTipoBaixa(TipoBaixaVO tipoBaixa) {
        this.tipoBaixa = tipoBaixa;
    }

}
