package vo.Pessoa;

import java.util.Set;
import javax.persistence.*;
import vo.Produto.ProdutoVO;

@Entity
@Table(name = "fornecedor")
public class FornecedorVO extends PessoaJuridicaVO{
    
    @ManyToMany(mappedBy = "listaFornecedores",fetch = FetchType.LAZY)
    private Set<ProdutoVO> listaProduto;

    public FornecedorVO() {
    }

    public FornecedorVO(Set<ProdutoVO> listaProduto) {
        this.listaProduto = listaProduto;
    }

    public Set<ProdutoVO> getListaProduto() {
        return listaProduto;
    }

    public void setListaProduto(Set<ProdutoVO> listaProduto) {
        this.listaProduto = listaProduto;
    }
    
    
}
