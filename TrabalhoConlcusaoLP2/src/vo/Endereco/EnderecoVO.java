package vo.Endereco;

import javax.persistence.*;

@Embeddable
public class EnderecoVO {
    
    @Column(length = 100,nullable = false)
    private String logradouro;
    @Column(length = 30,nullable = true)
    private String complemento;
    @Column(length = 10,nullable = false)
    private String numero;
    @Column(length = 10,nullable = true)
    private String CEP;
    @ManyToOne(fetch = FetchType.EAGER)
    private BairroVO bairroVO;

    public EnderecoVO() {
    }

    public EnderecoVO(String logradouro, String complemento, String numero, String CEP, BairroVO bairroVO) {
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.numero = numero;
        this.CEP = CEP;
        this.bairroVO = bairroVO;
    }

    public BairroVO getBairroVO() {
        return bairroVO;
    }

    public void setBairroVO(BairroVO bairroVO) {
        this.bairroVO = bairroVO;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }
    
}
