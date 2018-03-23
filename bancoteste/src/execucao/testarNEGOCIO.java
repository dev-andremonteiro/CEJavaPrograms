
package execucao;

import DAO.GrupoProdutoDAO;
import DAO.ProdutoDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import negocio.GrupoProduto;
import negocio.NegocioException;
import negocio.Produto;
import persistencia.FabricaEntityManager;
import persistencia.PersistenciaException;
import vo.GrupoProdutoVO;
import vo.ProdutoVO;

public class testarNEGOCIO {
    
    public static void main(String[] args) {
        /*
        GrupoProdutoVO grupoVO = new GrupoProdutoVO();
        grupoVO.setNome(JOptionPane.showInputDialog("Nome:"));
        grupoVO.setMargemlucro(Float.parseFloat(JOptionPane.showInputDialog("Margem de Lucro:")));
        grupoVO.setPromocao(Float.parseFloat(JOptionPane.showInputDialog("Percentual de Promoção:")));
        try{
            GrupoProduto grupoProduto = new GrupoProduto();
            grupoProduto.inserir(grupoVO);
        }catch(NegocioException ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        */
        
        /*
        ProdutoVO produtoVO = new ProdutoVO();
        
        produtoVO.setNome(JOptionPane.showInputDialog("Nome:"));
        produtoVO.setMargemLucro(Float.parseFloat(JOptionPane.showInputDialog("Margem de Lucro:")));
        produtoVO.setPromocao(Float.parseFloat(JOptionPane.showInputDialog("Percentual de Promoção:")));
        produtoVO.setEstoque(Integer.parseInt(JOptionPane.showInputDialog("Estoque:")));
        produtoVO.setValorCompra(Float.parseFloat(JOptionPane.showInputDialog("Valor da Compra:")));
        produtoVO.setVenda(Float.parseFloat(JOptionPane.showInputDialog("Valor de Venda:")));
        try {
            GrupoProdutoDAO grupoDAO = new GrupoProdutoDAO(FabricaEntityManager.getEntityManager());
            produtoVO.setGrupo(grupoDAO.buscarPorCodigo(Integer.parseInt(JOptionPane.showInputDialog("Código de Grupo de Produto:"))));
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        
        try {
            Produto produto = new Produto();
            produto.inserir(produtoVO);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        */
        
        
        
        ProdutoVO produtoVO = new ProdutoVO();
        try {
            
            ProdutoDAO produtoDAO = new ProdutoDAO(FabricaEntityManager.getEntityManager());
             produtoDAO.iniciarTransacao();
            Produto produto = new Produto();
            
            produtoVO = produtoDAO.buscarPorCodigo(152);
          
            produto.excluir(produtoVO);
            produtoDAO.confirmarTransacao();
        } catch (NegocioException | PersistenciaException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        
        
        
        
    }
    
}
