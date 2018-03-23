package persistencia;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.EntityManager;

public class FabricaEntityManager{
    private static EntityManagerFactory entityManagerFactory = null;
    
    private FabricaEntityManager(){        
    }
    
    static{
        entityManagerFactory = Persistence.createEntityManagerFactory("unidadebd");        
    }
    
    public static EntityManager getEntityManager() throws PersistenciaException{
        if (entityManagerFactory == null) {
            throw new PersistenciaException("Unidade de persistência não iniciada");
        }
        return entityManagerFactory.createEntityManager();
    }
    
}

