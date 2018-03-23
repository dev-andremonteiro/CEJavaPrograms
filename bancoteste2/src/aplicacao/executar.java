package aplicacao;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import persistencia.A_VO;
import persistencia.PessoaVO;
import persistencia.TelefoneVO;
import persistencia.TipoFoneEnum;

/**
 *
 * @author André
 */
public class executar {

    public static void main(String[] args) {
        EntityManagerFactory fac = Persistence.createEntityManagerFactory("unidadebd");
        EntityManager ent = fac.createEntityManager();
        
        Set<TelefoneVO> listaFone = new HashSet();
        listaFone.add(new TelefoneVO(TipoFoneEnum.TRABALHO,"+55","065","7070-7070"));
        listaFone.add(new TelefoneVO(TipoFoneEnum.CELULAR,"+55","065","8040-4080"));
        
        
        PessoaVO pessoaVO = new PessoaVO();
        pessoaVO.setNome("Testando");
        pessoaVO.setListaFone(listaFone);
        
        ent.getTransaction().begin();
        ent.persist(pessoaVO);
        ent.getTransaction().commit();  
    }
    
}
