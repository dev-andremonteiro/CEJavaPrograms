
package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import vo.GrupoProdutoVO;

public class IncluirGrupoProduto {
    
    public static void main(String[] args) {
        EntityManagerFactory factory = null;
        EntityManager ent = null;
        
        try{
            factory = Persistence.createEntityManagerFactory("unidadebd");
            ent = factory.createEntityManager();
        }catch(Exception ex){
            System.out.println("Erro ao estabelecer conexão com banco de dados - "+ex.getMessage());
        }
        GrupoProdutoVO gp = new GrupoProdutoVO();
        gp.setNome("Grupo Teste");
        gp.setMargemlucro(10);
        gp.setPromocao(30);
        ent.getTransaction().begin();
        ent.persist(gp);
        ent.getTransaction().commit();
        // SELECT G FROM GRUPOPRODUTO G WHERE TRIM(G.NOME)='GRUPO TESTE'"
    }
    
}
