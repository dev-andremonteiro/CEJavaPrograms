package persistencia;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class FabricaEntityManager {

    private static EntityManagerFactory entityManagerFactory = null;

    private FabricaEntityManager(){} // para impedir instanciamento
    
    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("UP-POSTGRE");
    }

    public static EntityManager getEntityManager() throws PersistenciaException {
        if (entityManagerFactory == null) {
            throw new PersistenciaException("Unidade de Persistência não iniciada");
        }
        return entityManagerFactory.createEntityManager();
    }
}

