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
@Table(name = "material")
public class MaterialVO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_material;

    @Column (length = 200 ,nullable = false)
    private String descricao;
    
    @Column (nullable = false)
    private int quantidade;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private GrupoVO grupo;

    public MaterialVO() {
        this.id_material = 0;
        this.descricao = "";
        this.quantidade = 0;
        this.grupo = new GrupoVO();
    }

    /**
     * @return the idMaterial
     */
    public int getIdMaterial() {
        return id_material;
    }

    /**
     * @param idMaterial the idMaterial to set
     */
    public void setIdMaterial(int idMaterial) {
        this.id_material = idMaterial;
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

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the grupo
     */
    public GrupoVO getGrupo() {
        return grupo;
    }

    /**
     * @param grupo the grupo to set
     */
    public void setGrupo(GrupoVO grupo) {
        this.grupo = grupo;
    }

   }
