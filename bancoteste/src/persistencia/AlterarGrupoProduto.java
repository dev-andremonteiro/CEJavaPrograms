package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import vo.GrupoProdutoVO;

public class AlterarGrupoProduto {
    public static void main(String[] args) {
        EntityManagerFactory fabrica = null;
        EntityManager ent = null;
        
        try{
            fabrica = Persistence.createEntityManagerFactory("unidadebd");
            ent = fabrica.createEntityManager();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        ent.getTransaction().begin();
        GrupoProdutoVO grupoVO = null;
        try{
            Query query = ent.createQuery("SELECT G FROM GrupoProdutoVO G WHERE TRIM(G.nome)='Grupo Teste'");
            grupoVO = (GrupoProdutoVO) query.getSingleResult();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        grupoVO.setMargemlucro(50);
        ent.getTransaction().commit();
        
    }
}
