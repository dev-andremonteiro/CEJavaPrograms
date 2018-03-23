package execucao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author André
 */
public class executar {
    
    public static void main(String[] args) {
        EntityManagerFactory fac = Persistence.createEntityManagerFactory("trabalhoconclusao");
        EntityManager ent = fac.createEntityManager();
        ent.close();
        fac.close();
    }
    
}
