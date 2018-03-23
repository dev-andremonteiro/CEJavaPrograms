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
@Table(name = "material_tipo_atividade")
public class MaterialTipoAtividadeVO {
    
    @EmbeddedId
    private MaterialTipoAtividadePKVO id;
    
    @Column (nullable = true)
    private int quantidadeNecessaria;

    public MaterialTipoAtividadeVO() {
        
        this.quantidadeNecessaria = 0;
    }

    /**
     * @return the id
     */
    public MaterialTipoAtividadePKVO getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(MaterialTipoAtividadePKVO id) {
        this.id = id;
    }

    /**
     * @return the quantidadeNecessaria
     */
    public int getQuantidadeNecessaria() {
        return quantidadeNecessaria;
    }

    /**
     * @param quantidadeNecessaria the quantidadeNecessaria to set
     */
    public void setQuantidadeNecessaria(int quantidadeNecessaria) {
        this.quantidadeNecessaria = quantidadeNecessaria;
    }
    
}
