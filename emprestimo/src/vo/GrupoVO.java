package vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Daniel
 */

@Entity
@Table(name = "grupo")
public class GrupoVO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_grupo;
    
    @Column (length = 18 ,nullable = false)
    private String cnpj;
    
    @Column (length = 100, nullable = false)
    private String nome;
    
    @Column (nullable = false)
    private int numeral;
    
    @Enumerated(EnumType.ORDINAL)
    private EnumUF regiao;
    
    @Enumerated(EnumType.ORDINAL)
    private EnumModalidade modalidade;
   
    public GrupoVO (){
        this.id_grupo=0;
        this.cnpj ="";
        this.nome = "";
        this.numeral=0;
        this.regiao = EnumUF.PA;
        this.modalidade = EnumModalidade.Básico;
    }

    /**
     * @return the idGrupo
     */
    public int getIdGrupo() {
        return id_grupo;
    }

    /**
     * @param idGrupo the idGrupo to set
     */
    public void setIdGrupo(int idGrupo) {
        this.id_grupo = idGrupo;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the numeral
     */
    public int getNumeral() {
        return numeral;
    }

    /**
     * @param numeral the numeral to set
     */
    public void setNumeral(int numeral) {
        this.numeral = numeral;
    }

    /**
     * @return the regiao
     */
    public EnumUF getRegiao() {
        return regiao;
    }

    /**
     * @param regiao the regiao to set
     */
    public void setRegiao(EnumUF regiao) {
        this.regiao = regiao;
    }

    /**
     * @return the modalidade
     */
    public EnumModalidade getModalidade() {
        return modalidade;
    }

    /**
     * @param modalidade the modalidade to set
     */
    public void setModalidade(EnumModalidade modalidade) {
        this.modalidade = modalidade;
    }
    
    
}
