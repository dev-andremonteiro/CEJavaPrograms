package negocio;

import java.util.List;
import vo.BaixaVO;
import vo.GrupoProdutoVO;
import vo.ProdutoVO;

public class SubSistemaProduto {

    private GrupoProduto grupo;
    private Produto produto;
    private RegistroBaixa baixa;

    public SubSistemaProduto() throws NegocioException {
        this.grupo = new GrupoProduto();
        this.produto = new Produto();
        this.baixa = new RegistroBaixa();
    }

    //-------------------------Produto------------------------------------------------
    public void inserirProduto(ProdutoVO produtoVO) throws NegocioException {
        produto.inserir(produtoVO);
    }

    //-------------------------GrupoProduto------------------------------------------------

    public void inserirGrupoProduto(GrupoProdutoVO grupoVO) throws NegocioException {
        grupo.inserir(grupoVO);
    }

    public void alterarProduto(ProdutoVO produtoVO) throws NegocioException {
        produto.alterar(produtoVO);
    }

    public void excluirProduto(int codigo) throws NegocioException {
        produto.excluir(codigo);
    }

    public List<ProdutoVO> calcularPrecoVenda(List<ProdutoVO> lista) {
        return produto.calcularPrecoVenda(lista);
    }

    public List<ProdutoVO> pesquisaProdutoParteNome(String parteNome) throws NegocioException {
        return produto.pesquisaParteNome(parteNome);
    }

    public ProdutoVO pesquisaProdutoCodigo(int codigo) throws NegocioException {
        return produto.pesquisaCodigo(codigo);
    }

    public void alterarGrupoProduto(GrupoProdutoVO grupoVO) throws NegocioException {
        grupo.alterar(grupoVO);
    }

    public void excluirGrupoProduto(int codigo) throws NegocioException {
        grupo.excluir(codigo);
    }

    public List<GrupoProdutoVO> buscarTodosGruposProdutos() throws NegocioException {
        return grupo.buscarTodos();
    }

    public GrupoProdutoVO buscarPorCodigoGrupoProduto(int codigo) throws NegocioException {
        return grupo.buscarPorCodigo(codigo);
    }

    //-------------------------BaixaEstoque------------------------------------------------

    public void baixarEstoque(BaixaVO baixaVO) throws NegocioException {
        baixa.baixarEstoque(baixaVO);
    }
}
