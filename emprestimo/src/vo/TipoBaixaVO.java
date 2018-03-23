package vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "tipo_baixa")
public class TipoBaixaVO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_tipo_baixa;
    
    @Column (length = 50 ,nullable = false)
    private String descricao;

    public TipoBaixaVO() {
        this.id_tipo_baixa=0;
        this.descricao="";
    }

    /**
     * @return the id_baixa
     */
    public int getIdBaixa() {
        return id_tipo_baixa;
    }

    /**
     * @param idBaixa the id_baixa to set
     */
    public void setIdBaixa(int idBaixa) {
        this.id_tipo_baixa = idBaixa;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
