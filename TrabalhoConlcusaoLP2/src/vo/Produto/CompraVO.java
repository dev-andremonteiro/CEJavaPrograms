package vo.Produto;

import java.sql.Date;
import java.util.Set;
import javax.persistence.*;
import vo.Pagamento.PagamentoVO;
import vo.Pessoa.FornecedorVO;

@Entity
@Table(name = "compra")
public class CompraVO {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long ID;
    @Column(nullable = false)
    private Date dataLancamento;
    @Column(nullable = false)
    private Date dataEnvio;
    @Column(nullable = true)
    private Date dataRecebimento;
    @Column(nullable = true)
    private Date dataProcessamento;
    @Enumerated(EnumType.ORDINAL)
    private SituacaoCompraEnum situacao;
    @OneToOne(fetch = FetchType.EAGER)
    private PagamentoVO pagamentoVO;
    @OneToOne(fetch = FetchType.EAGER)
    private FornecedorVO fornecedorVO;
    @OneToMany(fetch = FetchType.LAZY)
    private Set<ItemCompraVO> listaItens;

    public CompraVO() {
    }

    public CompraVO(long ID, Date dataLancamento, Date dataEnvio, Date dataRecebimento, Date dataProcessamento, SituacaoCompraEnum situacao, PagamentoVO pagamentoVO, FornecedorVO fornecedorVO, Set<ItemCompraVO> listaItens) {
        this.ID = ID;
        this.dataLancamento = dataLancamento;
        this.dataEnvio = dataEnvio;
        this.dataRecebimento = dataRecebimento;
        this.dataProcessamento = dataProcessamento;
        this.situacao = situacao;
        this.pagamentoVO = pagamentoVO;
        this.fornecedorVO = fornecedorVO;
        this.listaItens = listaItens;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public Date getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(Date dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public Date getDataProcessamento() {
        return dataProcessamento;
    }

    public void setDataProcessamento(Date dataProcessamento) {
        this.dataProcessamento = dataProcessamento;
    }

    public SituacaoCompraEnum getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoCompraEnum situacao) {
        this.situacao = situacao;
    }

    public PagamentoVO getPagamentoVO() {
        return pagamentoVO;
    }

    public void setPagamentoVO(PagamentoVO pagamentoVO) {
        this.pagamentoVO = pagamentoVO;
    }

    public FornecedorVO getFornecedorVO() {
        return fornecedorVO;
    }

    public void setFornecedorVO(FornecedorVO fornecedorVO) {
        this.fornecedorVO = fornecedorVO;
    }

    public Set<ItemCompraVO> getListaItens() {
        return listaItens;
    }

    public void setListaItens(Set<ItemCompraVO> listaItens) {
        this.listaItens = listaItens;
    }
    
}
