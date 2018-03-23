package vo.Produto;

import java.util.Set;
import javax.persistence.*;
import vo.Pessoa.FornecedorVO;

@Entity
@Table(name = "produto")
public class ProdutoVO {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long ID;
    @Column(length = 30,nullable = false)
    private String nome;
    @Column(precision = 5,scale = 2,nullable = false)
    private float margemlucro;
    @Column(precision = 5,scale = 2,nullable = false)
    private float percPromocao;
    @Column(precision = 5,scale = 2,nullable = false)
    private float percComissao;
    @Column(precision = 5,scale = 2,nullable = false)
    private float valorCompra;
    @Column(precision = 5,scale = 2,nullable = false)
    private float valorVenda;
    @ManyToOne(fetch = FetchType.EAGER)
    private CategoriaVO categoriaVO;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable (name = "fornecedor_produto",
            joinColumns = {@JoinColumn(name = "id_fornecedor")},
            inverseJoinColumns = {@JoinColumn(name = "id_produto")})
    private Set<FornecedorVO> listaFornecedores;

    public ProdutoVO() {
    }

    public ProdutoVO(long ID, String nome, float margemlucro, float percPromocao, float percComissao, float valorCompra, float valorVenda, CategoriaVO categoriaVO, Set<FornecedorVO> listaFornecedores) {
        this.ID = ID;
        this.nome = nome;
        this.margemlucro = margemlucro;
        this.percPromocao = percPromocao;
        this.percComissao = percComissao;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.categoriaVO = categoriaVO;
        this.listaFornecedores = listaFornecedores;
    }

    

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getMargemlucro() {
        return margemlucro;
    }

    public void setMargemlucro(float margemlucro) {
        this.margemlucro = margemlucro;
    }

    public float getPercPromocao() {
        return percPromocao;
    }

    public void setPercPromocao(float percPromocao) {
        this.percPromocao = percPromocao;
    }

    public float getPercComissao() {
        return percComissao;
    }

    public void setPercComissao(float percComissao) {
        this.percComissao = percComissao;
    }

    public float getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(float valorCompra) {
        this.valorCompra = valorCompra;
    }

    public float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

    public CategoriaVO getCategoriaVO() {
        return categoriaVO;
    }

    public void setCategoriaVO(CategoriaVO categoriaVO) {
        this.categoriaVO = categoriaVO;
    }

    public Set<FornecedorVO> getListaFornecedores() {
        return listaFornecedores;
    }

    public void setListaFornecedores(Set<FornecedorVO> listaFornecedores) {
        this.listaFornecedores = listaFornecedores;
    }
}
