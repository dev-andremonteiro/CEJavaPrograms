package vo.Produto;

import javax.persistence.*;

@Entity
@Table(name = "itemcompra")
public class ItemCompraVO {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long ID;
    @ManyToOne(fetch = FetchType.EAGER)
    private ProdutoVO produtoVO;
    @Column(nullable = false)
    private int quantidade;

    public ItemCompraVO() {
    }

    public ItemCompraVO(long ID, ProdutoVO produtoVO, int quantidade) {
        this.ID = ID;
        this.produtoVO = produtoVO;
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public ProdutoVO getProdutoVO() {
        return produtoVO;
    }

    public void setProdutoVO(ProdutoVO produtoVO) {
        this.produtoVO = produtoVO;
    }
    
}
