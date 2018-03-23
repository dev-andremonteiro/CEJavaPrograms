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
@Table(name = "funcao")
public class FuncaoVO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_funcao;
    
    @Column (length = 50 ,nullable = false)
    private String descricao;

    public FuncaoVO() {
        this.id_funcao=0;
        this.descricao="";
    }

    public int getId_tipo() {
        return id_funcao;
    }

    public void setId_tipo(int id_tipo) {
        this.id_funcao = id_tipo;
    }

    public String getNome() {
        return descricao;
    }

    public void setNome(String Nome) {
        this.descricao = Nome;
    }
    
}
