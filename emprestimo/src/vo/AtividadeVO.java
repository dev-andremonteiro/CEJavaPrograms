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
@Table(name = "atividade")
public class AtividadeVO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_atividade;
    
    @Column (length = 100 ,nullable = false)
    private String nome;
    
    @Column (length = 100 ,nullable = true)
    private String tema;
    
    @Column (length = 100 ,nullable = true)
    private String local;
    
    @Column (nullable = true)
    private Date dt_inicio;
    
    @Column (nullable = true)
    private Date dt_fim;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private GrupoVO grupo;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private TipoAtividadeVO tipo;

    public AtividadeVO() {
        this.id_atividade = 0;
        this.nome = "";
        this.tema = "";
        this.local = "";
        this.grupo = new GrupoVO();
        this.tipo = new TipoAtividadeVO();
    }

    /**
     * @return the id_atividade
     */
    public int getId_atividade() {
        return id_atividade;
    }

    /**
     * @param id_atividade the id_atividade to set
     */
    public void setId_atividade(int id_atividade) {
        this.id_atividade = id_atividade;
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
     * @return the tema
     */
    public String getTema() {
        return tema;
    }

    /**
     * @param tema the tema to set
     */
    public void setTema(String tema) {
        this.tema = tema;
    }

    /**
     * @return the local
     */
    public String getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     * @return the dt_inicio
     */
    public Date getDataInicio() {
        return dt_inicio;
    }

    /**
     * @param dataInicio the dt_inicio to set
     */
    public void setDataInicio(Date dataInicio) {
        this.dt_inicio = dataInicio;
    }

    /**
     * @return the dt_fim
     */
    public Date getDataFim() {
        return dt_fim;
    }

    /**
     * @param dataFim the dt_fim to set
     */
    public void setDataFim(Date dataFim) {
        this.dt_fim = dataFim;
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

    /**
     * @return the tipo
     */
    public TipoAtividadeVO getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoAtividadeVO tipo) {
        this.tipo = tipo;
    }

}
