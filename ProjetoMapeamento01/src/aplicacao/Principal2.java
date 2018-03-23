package aplicacao;
import javax.persistence.EntityManager;
import persistencia.FabricaEntityManager;
import persistencia.PersistenciaException;
public class Principal2 {
    public static void main(String args[]) {
        try {
            EntityManager entityManager = FabricaEntityManager.getEntityManager();
            entityManager.getTransaction().begin();
            
            entityManager.getTransaction().commit();
        } catch (PersistenciaException ex) {
            System.out.println(ex.toString());
        }
    }
}


