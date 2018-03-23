package persistencia;

import persistencia.PersistenciaException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FabricaEntityManager{
    
    static EntityManagerFactory ent=null;

    private FabricaEntityManager() {}
    
    static{
        ent = Persistence.createEntityManagerFactory("unidadebd");
    }
    
    public static EntityManager getEntityManager() throws PersistenciaException{
        if(ent == null){
            throw new PersistenciaException("Não foi possivel inicializar a unidade de persistência.");
        }
        return ent.createEntityManager();
    }
    
}
