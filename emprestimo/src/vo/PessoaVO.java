
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
@Table(name = "pessoa")
public class PessoaVO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_membro;
    
    @Column (length = 100 ,nullable = false)
    private String nome;
    
    @Column (length = 20 ,nullable = true)
    private String rg;
    
    @Column (length = 14 ,nullable = true)
    private String cpf;
    
    @Column (length = 10 ,nullable = true)
    private String loguin;
    
    @Column (length = 10 ,nullable = true)
    private String senha;
    
    @Column (length = 20 ,nullable = true)
    private String telefone;
    
    @Column (length = 50 ,nullable = true)
    private String email;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private FuncaoVO funcao;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private PatrulhaVO patrulha;

    public PessoaVO() {
        this.id_membro=0;
        this.nome="";        
        this.rg="";
        this.cpf="";
        this.email="";
        this.telefone="";
        this.loguin="";
        this.senha="";
        this.funcao= new FuncaoVO();
        this.patrulha= new PatrulhaVO();
    }

    /**
     * @return the id_membro
     */
    public int getIdPessoa() {
        return id_membro;
    }

    /**
     * @param idPessoa the id_membro to set
     */
    public void setIdPessoa(int idPessoa) {
        this.id_membro = idPessoa;
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
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the funcao
     */
    public FuncaoVO getFuncao() {
        return funcao;
    }

    /**
     * @param funcao the funcao to set
     */
    public void setFuncao(FuncaoVO funcao) {
        this.funcao = funcao;
    }

    /**
     * @return the login
     */
    public String getLoguin() {
        return loguin;
    }

    /**
     * @param loguin the login to set
     */
    public void setLoguin(String loguin) {
        this.loguin = loguin;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the patrulha
     */
    public PatrulhaVO getPatrulha() {
        return patrulha;
    }

    /**
     * @param patrulha the patrulha to set
     */
    public void setPatrulha(PatrulhaVO patrulha) {
        this.patrulha = patrulha;
    }

}
