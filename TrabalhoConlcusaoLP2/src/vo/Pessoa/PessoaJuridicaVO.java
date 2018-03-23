package vo.Pessoa;

import javax.persistence.*;


@Entity
@Table(name = "pessoajuridica")
@Inheritance(strategy = InheritanceType.JOINED)
public class PessoaJuridicaVO extends PessoaVO{
    @Column(length = 18,nullable = false)
    private String CNPJ;
    @Column(length = 20,nullable = false)
    private String inscricao;
    @Column(length = 50,nullable = false)
    private String fantasia;

    public PessoaJuridicaVO() {
    }

    public PessoaJuridicaVO(String CNPJ, String inscricao, String fantasia) {
        this.CNPJ = CNPJ;
        this.inscricao = inscricao;
        this.fantasia = fantasia;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getInscricao() {
        return inscricao;
    }

    public void setInscricao(String inscricao) {
        this.inscricao = inscricao;
    }
    
}
