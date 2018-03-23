package execucao;

import DAO.ProdutoDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import persistencia.FabricaEntityManager;
import persistencia.PersistenciaException;
import vo.ProdutoVO;


public class testarDAO {
    
    public static void main(String[] args) {
        
        /*
        ProdutoVO produtoVO = new ProdutoVO();
        produtoVO.setNome("Xuxu");
        produtoVO.setMargemLucro(30);
        produtoVO.setPromocao(20);
        produtoVO.setEstoque(10);
        produtoVO.setValorCompra(5);
        produtoVO.setVenda(7);
        
        try {
            ProdutoDAO produtoDAO = new ProdutoDAO(FabricaEntityManager.getEntityManager());
            produtoDAO.iniciarTransacao();
            produtoDAO.incluir(produtoVO);
            produtoDAO.confirmarTransacao();
        } catch (PersistenciaException ex) {
            produtoDAO.cancelarTransacao();
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        */
        /*
        ProdutoVO produtoVO = new ProdutoVO();
        ProdutoDAO produtoDAO = null;
        try {
            produtoDAO = new ProdutoDAO(FabricaEntityManager.getEntityManager());
            produtoDAO.iniciarTransacao();
            produtoVO = produtoDAO.buscarPorCodigo(301);
            produtoDAO.excluir(produtoVO);
            produtoDAO.confirmarTransacao();
        } catch (PersistenciaException ex) {
            produtoDAO.cancelarTransacao();
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        */
        /*
        ProdutoVO produtoVO = new ProdutoVO();
        ProdutoDAO produtoDAO = null;
        try{
            produtoDAO = new ProdutoDAO(FabricaEntityManager.getEntityManager());
            produtoDAO.iniciarTransacao();
            produtoVO = produtoDAO.buscarPorCodigo(152);
            produtoVO.setEstoque(100);
            produtoVO.setPromocao(25);
            produtoDAO.alterar(produtoVO);
            produtoDAO.confirmarTransacao();
        } catch (PersistenciaException ex) {
            produtoDAO.cancelarTransacao();
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        */
        
    }
    
}
