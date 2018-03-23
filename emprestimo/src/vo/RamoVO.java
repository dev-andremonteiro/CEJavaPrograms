package vo;

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
@Table(name = "ramo")
public class RamoVO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_ramo;
    
    @Column (length = 50 ,nullable = false)
    private String nome;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private GrupoVO grupo;
    
    public RamoVO(){
        this.id_ramo=0;
        this.nome = "";
        this.grupo = new GrupoVO();
    }

    public int getId_ramo() {
        return id_ramo;
    }

    public void setId_ramo(int id_ramo) {
        this.id_ramo = id_ramo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public GrupoVO getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoVO grupo) {
        this.grupo = grupo;
    }
    
    
    
    
    
    
}
