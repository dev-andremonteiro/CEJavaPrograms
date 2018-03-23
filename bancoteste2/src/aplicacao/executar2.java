
package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistencia.B_VO;

/**
 *
 * @author André
 */
public class executar2 {
    public static void main(String[] args) {
        
        EntityManagerFactory fac = Persistence.createEntityManagerFactory("unidadebd");
        EntityManager ent = fac.createEntityManager();
        
        
        B_VO b = new B_VO();
        b.setNome("TestandoB");
        b.setX(0);
        
        ent.getTransaction().begin();
        ent.persist(b);
        ent.getTransaction().commit(); 
        
    }
}
