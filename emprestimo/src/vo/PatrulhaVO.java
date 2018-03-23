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
@Table(name = "patrulha")
public class PatrulhaVO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_patrulha; 
    
    @Column (length = 50 ,nullable = false)
    private String nome;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private RamoVO ramo;

    public PatrulhaVO() {
        this.id_patrulha=0;
        this.nome="";
        this.ramo= new RamoVO();
    }

    public int getIdEquipe() {
        return id_patrulha;
    }

    public void setIdEquipe(int idEquipe) {
        this.id_patrulha = idEquipe;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public RamoVO getRamo() {
        return ramo;
    }

    public void setRamo(RamoVO ramo) {
        this.ramo = ramo;
    }

    
    
}   
