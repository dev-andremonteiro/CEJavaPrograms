
package aplicacao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import persistencia.A_VO;
import persistencia.B_VO;
import persistencia.C_VO;

/**
 *
 * @author André
 */
public class executar4 {
    public static void main(String[] args) {
        
        EntityManagerFactory fac = Persistence.createEntityManagerFactory("unidadebd");
        EntityManager ent = fac.createEntityManager();
        A_VO a = new A_VO();
        
        Query q = ent.createQuery("SELECT A FROM A_VO A");
        List<A_VO> List = q.getResultList();
        int x = 0;
        while(List.size() > x){
            System.out.println(List.get(x).getCodigo() + "---" + List.get(x).getNome());
            x++;
        }
        
        System.out.println("-------------------------------");
        B_VO b = new B_VO();
        
        q = ent.createQuery("SELECT A FROM B_VO A");
        List<B_VO> List2 = q.getResultList();
        x = 0;
        while(List2.size() > x){
            System.out.println(List2.get(x).getCodigo() + "---" + List2.get(x).getX());
            x++;
        }
        
        System.out.println("-------------------------------");
        C_VO c = new C_VO();
        
        q = ent.createQuery("SELECT A FROM C_VO A");
        List<C_VO> List3 = q.getResultList();
        x = 0;
        while(List3.size() > x){
            System.out.println(List3.get(x).getCodigo() + "---" + List3.get(x).getY());
            x++;
        }
        
    }
}
