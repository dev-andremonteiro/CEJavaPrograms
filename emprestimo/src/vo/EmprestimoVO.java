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
@Table(name = "emprestimo")
public class EmprestimoVO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_emprestimo;
    
    @Column (nullable = false)
    private Date dt_emprestimo;
    
    @Column (nullable = true)
    private Date dt_devolucao;
    
    @ManyToOne(fetch = FetchType.EAGER)     
    private PessoaVO pessoa;
    
    @ManyToOne(fetch = FetchType.EAGER)     
    private AtividadeVO atividade;

    public EmprestimoVO() {
        this.id_emprestimo = 0;
        this.pessoa = new PessoaVO();
        this.atividade = new AtividadeVO();
    }

    /**
     * @return the id_emprestimo
     */
    public int getIdEmprestimo() {
        return id_emprestimo;
    }

    /**
     * @param idEmprestimo the id_emprestimo to set
     */
    public void setIdEmprestimo(int idEmprestimo) {
        this.id_emprestimo = idEmprestimo;
    }

    /**
     * @return the dt_emprestimo
     */
    public Date getDataEmprestimo() {
        return dt_emprestimo;
    }

    /**
     * @param dataEmprestimo the dt_emprestimo to set
     */
    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dt_emprestimo = dataEmprestimo;
    }

    /**
     * @return the dt_devolucao
     */
    public Date getDataDevolucao() {
        return dt_devolucao;
    }

    /**
     * @param dataDevolucao the dt_devolucao to set
     */
    public void setDataDevolucao(Date dataDevolucao) {
        this.dt_devolucao = dataDevolucao;
    }

    /**
     * @return the pessoa
     */
    public PessoaVO getPessoa() {
        return pessoa;
    }

    /**
     * @param pessoa the pessoa to set
     */
    public void setPessoa(PessoaVO pessoa) {
        this.pessoa = pessoa;
    }

    /**
     * @return the atividade
     */
    public AtividadeVO getAtividade() {
        return atividade;
    }

    /**
     * @param atividade the atividade to set
     */
    public void setAtividade(AtividadeVO atividade) {
        this.atividade = atividade;
    }
    
}