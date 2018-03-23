package vo.Pagamento;

import java.sql.Date;
import javax.persistence.*;


@Entity
@Table(name = "parcelapagamento")
public class ParcelaPagamentoVO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long ID;
    @Column(nullable = false)
    private Date dataOperacao;
    @Column(nullable = false)
    private Date dataVencimento;
    @Column(nullable = false)
    private Date dataPagamento;
    @Column(nullable = true)
    private double valorOriginal;
    @Column(nullable = true)
    private double valorDesconto;
    @Column(nullable = true)
    private double valorJuro;
    @Column(nullable = true)
    private double valorMulta;
    @Column(nullable = true)
    private double valorTotalPago;
    @Enumerated(EnumType.ORDINAL)
    private TipoPagamentoEnum tipoPagamento;
    @OneToOne(fetch = FetchType.EAGER)
    private DocumentoPagamentoVO documentoPagamentoVO;

    public ParcelaPagamentoVO() {
    }

    public ParcelaPagamentoVO(long ID, Date dataOperacao, Date dataVencimento, Date dataPagamento, double valorOriginal, double valorDesconto, double valorJuro, double valorMulta, double valorTotalPago, TipoPagamentoEnum tipoPagamento, DocumentoPagamentoVO documentoPagamentoVO) {
        this.ID = ID;
        this.dataOperacao = dataOperacao;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.valorOriginal = valorOriginal;
        this.valorDesconto = valorDesconto;
        this.valorJuro = valorJuro;
        this.valorMulta = valorMulta;
        this.valorTotalPago = valorTotalPago;
        this.tipoPagamento = tipoPagamento;
        this.documentoPagamentoVO = documentoPagamentoVO;
    }

    public DocumentoPagamentoVO getDocumentoPagamentoVO() {
        return documentoPagamentoVO;
    }

    public void setDocumentoPagamentoVO(DocumentoPagamentoVO documentoPagamentoVO) {
        this.documentoPagamentoVO = documentoPagamentoVO;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public Date getDataOperacao() {
        return dataOperacao;
    }

    public void setDataOperacao(Date dataOperacao) {
        this.dataOperacao = dataOperacao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public double getValorOriginal() {
        return valorOriginal;
    }

    public void setValorOriginal(double valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public double getValorJuro() {
        return valorJuro;
    }

    public void setValorJuro(double valorJuro) {
        this.valorJuro = valorJuro;
    }

    public double getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(double valorMulta) {
        this.valorMulta = valorMulta;
    }

    public double getValorTotalPago() {
        return valorTotalPago;
    }

    public void setValorTotalPago(double valorTotalPago) {
        this.valorTotalPago = valorTotalPago;
    }

    public TipoPagamentoEnum getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamentoEnum tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
    
    
}
