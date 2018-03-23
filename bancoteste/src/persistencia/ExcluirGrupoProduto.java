package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import vo.GrupoProdutoVO;

public class ExcluirGrupoProduto {
    
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
            Query query = ent.createQuery("SELECT G FROM GrupoProdutoVO G WHERE G.codigo = 1");
            grupoVO = (GrupoProdutoVO) query.getSingleResult();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        ent.getTransaction().commit();
        ent.getTransaction().begin();
        ent.remove(grupoVO);
        ent.getTransaction().commit();
    }
    
}
