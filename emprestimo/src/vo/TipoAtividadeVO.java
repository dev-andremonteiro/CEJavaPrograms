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
@Table(name = "tipo_atividade")
public class TipoAtividadeVO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_tipo;
    
    @Column (length = 50 ,nullable = false)
    private String nome_tipo;

    public TipoAtividadeVO() {
        this.id_tipo=0;
        this.nome_tipo="";
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getNome() {
        return nome_tipo;
    }

    public void setNome(String Nome) {
        this.nome_tipo = Nome;
    }
    
}
