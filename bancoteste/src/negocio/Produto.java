
package negocio;

import DAO.ProdutoDAO;
import persistencia.FabricaEntityManager;
import persistencia.PersistenciaException;
import vo.ProdutoVO;

public class Produto {
    
    ProdutoDAO produtoDAO;

    public Produto() throws NegocioException {
        try {
            produtoDAO = new ProdutoDAO(FabricaEntityManager.getEntityManager());
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao iniciar persistência" + ex.getMessage());
        }
    }
    
    public void inserir(ProdutoVO produtoVO) throws NegocioException {

        String mensagemErros = this.validarDados(produtoVO);

        if (!mensagemErros.isEmpty()) {
            throw new NegocioException(mensagemErros);
        }

        try {
            produtoDAO.iniciarTransacao();
            produtoDAO.incluir(produtoVO);
            produtoDAO.confirmarTransacao();
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao incluir Produto -" + ex.getMessage());
        }

    }
    
     public void alterar(ProdutoVO produtoVO) throws NegocioException {

        String mensagemErros = this.validarDados(produtoVO);

        if (!mensagemErros.isEmpty()) {
            throw new NegocioException(mensagemErros);
        }

        try {
            produtoDAO.iniciarTransacao();
            produtoDAO.alterar(produtoVO);
            produtoDAO.confirmarTransacao();
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao alterar Produto -" + ex.getMessage());
        }

    }
     
     public void excluir(ProdutoVO produtoVO) throws NegocioException {

        try {
            produtoDAO.iniciarTransacao();
            produtoDAO.excluir(produtoVO);
            produtoDAO.confirmarTransacao();
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao excluir Produto -" + ex.getMessage());
        }

    }
    
    public String validarDados(ProdutoVO produtoVO){
        String mensagemErros = "";
        
        if(produtoVO.getNome().length() == 0){
            mensagemErros += "Nome não pode ser vazio.";
        }
        
        if(produtoVO.getValorCompra() < 0){
            mensagemErros += "Valor de compra não pode ser negativo.";
        }
        
        if(produtoVO.getVenda() < 0){
            mensagemErros += "Valor de venda não pode ser negativo.";
        }
        
        if (produtoVO.getMargemLucro()< 0) {
            mensagemErros += "\n Margem deve ser maior que zero.";
        }

        if (produtoVO.getPromocao() < 0 || produtoVO.getPromocao() > 100) {
            mensagemErros += "\nO Percentual de Promoção deve ser entre 0 e 100.";
        }
        
        return mensagemErros;
    }
    
}
