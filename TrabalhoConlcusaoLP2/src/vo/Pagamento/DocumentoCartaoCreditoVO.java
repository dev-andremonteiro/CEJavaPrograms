package vo.Pagamento;

import javax.persistence.*;


@Entity
@Table(name = "documentocartaocredito")
public class DocumentoCartaoCreditoVO extends DocumentoPagamentoVO{
    @Column(length = 16,nullable = false)
    private String numero;
    @Column(length = 5,nullable = false)
    private String validade;
    @ManyToOne(fetch = FetchType.EAGER)
    private BandeiraCartaoVO bandeiraVO; 

    public DocumentoCartaoCreditoVO() {
    }

    public DocumentoCartaoCreditoVO(String numero, String validade, BandeiraCartaoVO bandeiraVO) {
        this.numero = numero;
        this.validade = validade;
        this.bandeiraVO = bandeiraVO;
    }

    public BandeiraCartaoVO getBandeiraVO() {
        return bandeiraVO;
    }

    public void setBandeiraVO(BandeiraCartaoVO bandeiraVO) {
        this.bandeiraVO = bandeiraVO;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }
    
}
