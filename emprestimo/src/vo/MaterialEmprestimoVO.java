package vo;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "material_emprestimo")
public class MaterialEmprestimoVO {
    
    @EmbeddedId
    private MaterialEmprestimoPKVO id;
    
    @Column (nullable = true)
    private int quantidade_usada;

    public MaterialEmprestimoVO() {

        this.quantidade_usada = 0;
    }
    
    /**
     * @return the id
     */
    public MaterialEmprestimoPKVO getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(MaterialEmprestimoPKVO id) {
        this.id = id;
    }

    /**
     * @return the quantidade_usada
     */
    public int getQuantidade_usada() {
        return quantidade_usada;
    }

    /**
     * @param quantidade_usada the quantidade_usada to set
     */
    public void setQuantidade_usada(int quantidade_usada) {
        this.quantidade_usada = quantidade_usada;
    }

}
