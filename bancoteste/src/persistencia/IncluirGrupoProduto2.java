package persistencia;

import DAO.GrupoProdutoDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import vo.GrupoProdutoVO;

public class IncluirGrupoProduto2 {

    public static void main(String[] args) {
        GrupoProdutoDAO grupoDAO = null;

        GrupoProdutoVO grupoVO = new GrupoProdutoVO();
        String nome = JOptionPane.showInputDialog("Digite o nome do Grupo de Produto");
        grupoVO.setNome(nome);
        float margemLucro = Float.parseFloat(JOptionPane.showInputDialog("Digite o % de margem de lucro do Grupo de Produto"));
        grupoVO.setMargemlucro(margemLucro);
        float promocao = Float.parseFloat(JOptionPane.showInputDialog("Digite o % da promocao do Grupo de Produto"));
        grupoVO.setPromocao(promocao);
        try {
            grupoDAO = new GrupoProdutoDAO(FabricaEntityManager.getEntityManager());
            grupoDAO.iniciarTransacao();
            grupoDAO.incluir(grupoVO);
            grupoDAO.confirmarTransacao();
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
            grupoDAO.cancelarTransacao();
        }
    }

}
