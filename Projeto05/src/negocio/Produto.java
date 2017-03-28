package negocio;

import java.util.List;
import persistencia.ConexaoBD;
import persistencia.GrupoProdutoDAO;
import persistencia.PersistenciaException;
import persistencia.ProdutoDAO;
import vo.ProdutoVO;

public class Produto {

    private ProdutoDAO produtoDAO;
    private GrupoProdutoDAO grupoDAO;

    public Produto() throws NegocioException {
        try {
            this.produtoDAO = new ProdutoDAO(ConexaoBD.getInstancia());
            this.grupoDAO = new GrupoProdutoDAO(ConexaoBD.getInstancia());
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao iniciar a Persistencia - " + ex.getMessage());
        }
    }

    public void inserir(ProdutoVO produtoVO) throws NegocioException {

        String mensagemErros = this.validarDados(produtoVO);

        if (!mensagemErros.isEmpty()) {
            throw new NegocioException(mensagemErros);
        }

        try {
            if(produtoDAO.incluir(produtoVO) == 0){
                throw new NegocioException("Inclusão não realizada!!");
            }
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao incluir o produto - " + ex.getMessage());
        }
    }

    public void alterar(ProdutoVO produtoVO) throws NegocioException {
        String mensagemErros = this.validarDados(produtoVO);

        if (!mensagemErros.isEmpty()) {
            throw new NegocioException(mensagemErros);
        }

        try {
            if(produtoDAO.alterar(produtoVO) == 0){
                throw new NegocioException("Alteração não realizada!!");
            }
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao alterar o produto - " + ex.getMessage());
        }
    }

    public void excluir(int codigo) throws NegocioException {
        try {
            if(produtoDAO.excluir(codigo) == 0){
                throw new NegocioException("Alteração não realizada!!");
            }
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao excluir o produto - " + ex.getMessage());
        }
    }

    public ProdutoVO pesquisaCodigo(int codigo) throws NegocioException {
        try {
            return produtoDAO.buscarPorCodigo(codigo);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao pesquisar produto pelo codigo - " + ex.getMessage());
        }
    }

    public List<ProdutoVO> pesquisaParteNome(String parteNome) throws NegocioException {
        try {
            return produtoDAO.buscarPorNome(parteNome);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao pesquisar produto pelo nome - " + ex.getMessage());
        }
    }

    public List<ProdutoVO> calcularPrecoVenda(List<ProdutoVO> lista){

        float venda;
        for(ProdutoVO produtoVO : lista){
            if(produtoVO.getMargemLucro() == 0){
                produtoVO.setMargemLucro(produtoVO.getGrupo().getMargemLucro());
            }
            if(produtoVO.getPromocao() == 0){
                produtoVO.setPromocao(produtoVO.getGrupo().getPromocao());
            }
            venda = produtoVO.getPrecoCompra() + (produtoVO.getPrecoCompra() * produtoVO.getMargemLucro() / 100);
            venda = venda - (venda * produtoVO.getPromocao() / 100);
            produtoVO.setVenda(venda);
        }
        return lista;
    }

    private String validarDados(ProdutoVO produtoVO) {

        String mensagemErros = "";

        if (produtoVO.getNome().length() == 0) {
            mensagemErros += "Nome não pode ser vazio";
        }

        if (produtoVO.getEstoque() < 0) {
            mensagemErros += "\nEstoque não pode ser negativo";
        }

        if (produtoVO.getPrecoCompra() <= 0) {
            mensagemErros += "\nPreço de compra deve ser maior que zero";
        }

        if (produtoVO.getMargemLucro() < 0) {
            mensagemErros += "\nA margem de Lucro não pode ser negativa";
        }

        if (produtoVO.getPromocao() < 0 || produtoVO.getPromocao() > 100) {
            mensagemErros += "\nO Percentual de Promoção deve ser entre 0 e 100";
        }

        try {
            if (grupoDAO.buscarPorCodigo(produtoVO.getGrupo().getCodigo()) == null) {
                mensagemErros += "\nO grupo do produto é inválido";
            }
        } catch (PersistenciaException ex) {
            mensagemErros += "\nErro ao validar o grupo do produto";
        }

        return mensagemErros;
    }

}
